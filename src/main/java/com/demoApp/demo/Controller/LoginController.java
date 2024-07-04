package com.demoApp.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "UserPage/login"; // return the name of the login view (e.g., login.html)
    }
}
