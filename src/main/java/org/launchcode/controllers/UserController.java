package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add")
    public String addForm(Model model) {
        model.addAttribute("title", "Signup");

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        if (user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        } else {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());

            return "user/add";
        }
    }

/*    //request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {

        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify) {
        if (user.equals(verify));

        return "user/add";
    }
*/

/*    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute User newUser) {
        CheeseData.add(newCheese);
        return "redirect:";
    }*/


}
