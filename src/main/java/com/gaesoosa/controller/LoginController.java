package com.gaesoosa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jujeong on 2015. 12. 28..
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/")
    public String login() {
        return "join";
    }
}
