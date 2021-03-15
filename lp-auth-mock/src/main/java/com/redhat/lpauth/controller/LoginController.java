package com.redhat.lpauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public String login(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        return "login";
    }
}
