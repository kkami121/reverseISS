package com.myproject.itemlink.controller;

import com.myproject.itemlink.entity.EmpInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<EmpInfo> me(HttpSession session) {
        EmpInfo empInfo = (EmpInfo) session.getAttribute("LOGIN_USER_INFO");
        if (empInfo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empInfo);
    }
}
