package com.example.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorType", "invalid");
        return "login";
    }

    @GetMapping("/login-error-username")
    public String loginErrorUsername(Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorType", "username");
        return "login";
    }

}
