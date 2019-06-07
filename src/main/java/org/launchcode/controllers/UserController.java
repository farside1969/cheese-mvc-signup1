package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add")
    public String addForm(Model model) {
        model.addAttribute("title", "Signup");
    //added new User attribute
        model.addAttribute(new User());

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors error, String verify) {

        if (error.hasErrors()) {
            model.addAttribute("user", user);

            return "user/add";
        }

        if (user.getPassword().equals(verify)) {
            model.addAttribute("user", user);
            return "user/index";
        } else {
    //preserves username and email if passwords don't match
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("verifyError", "Passwords must match");

            return "user/add";
        }
    }
}
