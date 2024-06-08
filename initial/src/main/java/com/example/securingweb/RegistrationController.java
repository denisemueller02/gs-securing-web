package com.example.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public RedirectView registerUser(@RequestParam String username, @RequestParam String password) {
        // Encode the password before saving it to the database
        String encodedPassword = passwordEncoder.encode(password);

        // Create a new user entity
        User newUser = new User(username, encodedPassword);

        // Save the user to the database
        userRepository.save(newUser);

        // Redirect to the login page after successful registration
        return new RedirectView("/login");
    }
}
