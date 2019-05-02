package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }
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
    public String processRemove(@RequestParam(value = "aCheeses", required = false, defaultValue = "") int[] aCheeses) {

        for (int cheese : aCheeses) {
            CheeseData.remove(cheese);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        Cheese theCheese = CheeseData.getById(cheeseId);
        String title = "Editing " + theCheese.getCheeseName() + "(Id# " + theCheese.getCheeseId() + ")";

        model.addAttribute("title", title);
        model.addAttribute("theCheese", theCheese);
        model.addAttribute(theCheese);
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@PathVariable int cheeseId,
                                  @ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()) {
            String title = "Editing " + newCheese.getCheeseName() + "(Id# " + newCheese.getCheeseId() + ")";
            model.addAttribute("title", title);
            Cheese theCheese = CheeseData.getById(cheeseId);
            model.addAttribute("theCheese", theCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        CheeseData.edit(cheeseId, newCheese.getCheeseName(), newCheese.getCheeseValue(), newCheese.getType(), newCheese.getCheeseRating());

        return "redirect:/cheese";
    }
}
