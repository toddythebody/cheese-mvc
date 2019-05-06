package org.launchcode.cheesemvc.controllers;


import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
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
        cheeseDao.save(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemove(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemove(@RequestParam(value = "cheeseIds", required = false, defaultValue = "") int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.deleteById(cheeseId);
        }

        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {

        Cheese theCheese = cheeseDao.findById(cheeseId).get();
        String title = "Editing " + theCheese.getCheeseName() + "(Id# " + theCheese.getId() + ")";

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
            String title = "Editing " + newCheese.getCheeseName() + "(Id# " + newCheese.getId() + ")";
            model.addAttribute("title", title);
            Cheese theCheese = cheeseDao.findById(cheeseId).get();
            model.addAttribute("theCheese", theCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        Cheese theCheese = cheeseDao.findById(cheeseId).get();
        theCheese.setCheeseName(newCheese.getCheeseName());
        theCheese.setCheeseValue(newCheese.getCheeseValue());
        theCheese.setType(newCheese.getType());
        theCheese.setCheeseRating(newCheese.getCheeseRating());
        cheeseDao.save(theCheese);
        return "redirect:/cheese";
    }
}
