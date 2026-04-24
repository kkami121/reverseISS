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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@Slf4j
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
            // JJWT의 WeakKeyException(RFC 7518 key 길이 제한) 우회:
            // Java 표준 Mac으로 서명 직접 검증 후 claim만 JJWT로 파싱
            verifyHmacSignature(token);

            String[] parts = token.split("\\.");
            Claims claims = Jwts.parserBuilder()
                    .requireIssuer(ssoProperties.getIssuer())
                    .requireAudience(ssoProperties.getAudience())
                    .build()
                    .parseClaimsJwt(parts[0] + "." + parts[1])
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
            log.warn("[SSO] 인증 실패 - {}: {}", e.getClass().getSimpleName(), e.getMessage());
            response.sendRedirect(ctx + "/unauthorized.html");
        }
    }

    private void verifyHmacSignature(String token) throws Exception {
        String[] parts = token.split("\\.");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid JWT format");

        byte[] keyBytes = ssoProperties.getSecret().getBytes(StandardCharsets.UTF_8);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(keyBytes, "HmacSHA256"));
        byte[] computed = mac.doFinal((parts[0] + "." + parts[1]).getBytes(StandardCharsets.UTF_8));
        byte[] provided  = Base64.getUrlDecoder().decode(padBase64(parts[2]));

        if (!MessageDigest.isEqual(computed, provided)) {
            throw new SecurityException("JWT signature does not match");
        }
    }

    private static String padBase64(String s) {
        return switch (s.length() % 4) {
            case 2 -> s + "==";
            case 3 -> s + "=";
            default -> s;
        };
    }
}
