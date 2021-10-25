package com.bookkeeping.accountingclone.Controller;

import com.bookkeeping.accountingclone.Model.User;
import com.bookkeeping.accountingclone.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm,
                          BindingResult bindingResult,
                          Model model){

        if (bindingResult.hasErrors()){
            return "registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "User with such username already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
