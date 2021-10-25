package com.bookkeeping.accountingclone.Controller;

import com.bookkeeping.accountingclone.Model.User;
import com.bookkeeping.accountingclone.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*@GetMapping("/registration")
    public String addPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(@RequestParam(name = "username") String username,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "password") String password){

        userRepository.save(new User(username, email, password));
        return "home";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }*/
}
