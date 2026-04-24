package com.myproject.itemlink.controller;

import com.myproject.itemlink.config.SsoProperties;
import com.myproject.itemlink.entity.EmpInfo;
import com.myproject.itemlink.repository.EmpMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@RestController
@RequiredArgsConstructor
public class SsoController {

    private final SsoProperties ssoProperties;
    private final EmpMapper empMapper;

    @GetMapping("/sso")
    public void sso(@RequestParam String token, HttpServletRequest request,
                    HttpSession session, HttpServletResponse response) throws IOException {
        String ctx = request.getContextPath();
        try {
            Key key = new SecretKeySpec(ssoProperties.getSecret().getBytes(StandardCharsets.UTF_8), "HmacSHA256");

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .requireIssuer(ssoProperties.getIssuer())
                    .requireAudience(ssoProperties.getAudience())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String userId = claims.get(ssoProperties.getClaimName(), String.class);
            if (userId == null || userId.isBlank()) {
                response.sendRedirect(ctx + "/unauthorized.html");
                return;
            }

            session.setAttribute("LOGIN_USER", userId);
            EmpInfo empInfo = empMapper.findByUserId(userId);
            if (empInfo != null) {
                session.setAttribute("LOGIN_USER_INFO", empInfo);
            }
            response.sendRedirect(ctx + "/");
        } catch (Exception e) {
            response.sendRedirect(ctx + "/unauthorized.html");
        }
    }
}
