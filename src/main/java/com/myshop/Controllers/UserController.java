package com.myshop.Controllers;

import com.myshop.Model.User;
import com.myshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model){

        if (user.getPassword() == null || !user.getPassword().equals(user.getPasswordConf())) {
            model.addAttribute("error", "Hasła nie są takie same.");
            return "register";
        }
        try {
            User userDB = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
            if(userDB != null) {
                model.addAttribute("error", "Błędne dane 1!");
                return "register";
            }
            userRepository.save(user);
        } catch (Exception e) {
            model.addAttribute("error", "Błędne dane 2!");
            return "register";
        }
        return "success";
    }
}
