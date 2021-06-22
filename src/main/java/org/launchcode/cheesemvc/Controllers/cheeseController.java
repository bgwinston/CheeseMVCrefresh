package org.launchcode.cheesemvc.Controllers;

import org.launchcode.cheesemvc.Controllers.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class cheeseController {
    static ArrayList<Cheese> cheeses= new ArrayList<Cheese>();
/*Switched from hashmap to arraylist because hashmap doesn't allow keys with the same names
 Created an constructor that will create objects that are stored in an array   */
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        Cheese newCheese= new Cheese(cheeseName,cheeseDescription);
        cheeses.add(newCheese);
        //Redirect to cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCheese(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses); //returns all values in cheeses hashmap
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheese) {

        for (String aCheese : cheese) {
            cheeses.remove(aCheese);
        }

        return "redirect:";
    }
}


