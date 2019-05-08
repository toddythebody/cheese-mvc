package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserDao userDao;

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

        for (User loopUser : userDao.findAll()) {
            if (loopUser.getUsername().equals(user.getUsername()) || loopUser.getEmail().equals(user.getEmail())) {
                String existError = "User exists: Use a different name and/or email";
                model.addAttribute("title", "Register");
                model.addAttribute("existError", existError);
                return "user/add";
            }
        }

        userDao.save(user);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        //userDao.save(user);
        model.addAttribute("title", "Home Page");
        model.addAttribute("name", "bob");
        return "redirect:";
    }

    @RequestMapping(value = "")
    public String index(Model model) {

        User user = (User) session.getAttribute("user");
        model.addAttribute("title", "Home Page");
        model.addAttribute("name", user.getUsername());
        return "user/index";
    }



}
