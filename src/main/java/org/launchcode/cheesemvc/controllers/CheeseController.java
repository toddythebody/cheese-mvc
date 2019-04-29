package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
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
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemove(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemove(@RequestParam(value = "aCheeses", required = false, defaultValue = "0") int[] aCheeses) {

        for (int cheese : aCheeses) {
            CheeseData.remove(cheese);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable("id") int cheeseId) {

        Cheese theCheese = CheeseData.getById(cheeseId);
        String title = "Editing " + theCheese.getCheeseName() + "(Id# " + theCheese.getCheeseId() + ")";

        model.addAttribute("title", title);
        model.addAttribute("theCheese", theCheese);

        return "cheese/edit";
    }

    @RequestMapping(value = "editPost", method = RequestMethod.POST)
    public String processEditForm(@RequestParam int cheeseId,@RequestParam String cheeseName,@RequestParam String cheeseValue) {

        CheeseData.edit(cheeseId, cheeseName, cheeseValue);

        return "redirect:";
    }
}
