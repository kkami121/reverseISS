package com.myproject.itemlink.controller;

import com.myproject.itemlink.entity.EmpInfo;
import com.myproject.itemlink.repository.EmpMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Profile("dev")
@RestController
@RequiredArgsConstructor
public class DevLoginController {

    private final EmpMapper empMapper;

    @GetMapping("/dev/login")
    public void devLogin(@RequestParam(defaultValue = "gypark") String userId,
                         HttpServletRequest request, HttpSession session,
                         HttpServletResponse response) throws IOException {
        session.setAttribute("LOGIN_USER", userId);
        EmpInfo empInfo = empMapper.findByUserId(userId);
        if (empInfo != null) {
            session.setAttribute("LOGIN_USER_INFO", empInfo);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
