package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    private static HashMap<String, String> cheeses = new HashMap<>();

    public static HashMap<String, String> cheeseGet() {
        return cheeses;
    }

    public static void cheeseSet(String cheeseKey, String cheeseValue) {
        cheeses.put(cheeseKey, cheeseValue);
    }

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseGet());
        model.addAttribute("head", "cheesers");
        model.addAttribute("title", "My Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesc) {
        cheeseSet(cheeseName, cheeseDesc);
        return "redirect:";
    }
}
