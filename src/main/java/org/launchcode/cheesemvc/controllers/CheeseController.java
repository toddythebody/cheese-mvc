package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.cheesemvc.models.Cheese.cheeseGet;
import static org.launchcode.cheesemvc.models.Cheese.cheeseSet;

@Controller
@RequestMapping("cheese")
public class CheeseController {

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

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemove(Model model) {

        model.addAttribute("cheeses", cheeseGet().keySet());
        model.addAttribute("title", "My Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemove(@RequestParam ArrayList<String> cheeses) {

        for (String cheese : cheeses) {
            cheeseGet().remove(cheese);
        }

        return "redirect:";
    }
}
