package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("title", "Register");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addProcess(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify) {
        String verifyError = "";

        if (!user.getPassword().equals(verify)) {
            verifyError = "Verify password does not match password";
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            model.addAttribute("verifyError", verifyError);
            return "user/add";
        }

        if (!verifyError.equals("")) {
            model.addAttribute("title", "Register");
            model.addAttribute("verifyError", verifyError);
            return "user/add";
        }

        if (!UserData.userExist(user)) {
            String existError = "User exists: Use a different name and/or email";
            model.addAttribute("title", "Register");
            model.addAttribute("existError", existError);
            return "user/add";
        }

        UserData.add(user);
        model.addAttribute("title", "Home Page");
        model.addAttribute("name", user.getUsername());
        return "user/index";
    }

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Home Page");
        model.addAttribute("name", "Bob");
        return "user/index";
    }



}
