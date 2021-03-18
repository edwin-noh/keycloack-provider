package com.redhat.lpauth.controller;

import com.redhat.lpauth.dto.AuthDTO;
import com.redhat.lpauth.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam Optional<String> error, Model model) {
        LOGGER.debug("Getting login page, error={}", error);
        model.addAttribute("doLogin", "/loginAction");
        return "loginForm";
    }

    @PostMapping("/loginAction")
    public String doLogin(AuthDTO auth) {
        UserDetails result = userService.loadUserById(auth.getId());
        return "/";
    }
}
