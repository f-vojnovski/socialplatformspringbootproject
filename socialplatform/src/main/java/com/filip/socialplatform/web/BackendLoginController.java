package com.filip.socialplatform.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*
    A temporary controller that I will use while I hopefully
    resolve the issues I have with logging in from the front-end
 */

@Controller
@SessionAttributes({"currentUser"})
public class BackendLoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
