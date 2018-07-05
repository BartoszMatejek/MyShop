package com.myshop.Controllers;

import com.myshop.Model.LoginUser;
import com.myshop.Model.User;
import com.myshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginUser", new LoginUser());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView loginSubmit(@ModelAttribute LoginUser loginUser, Model model) {
        User user = userRepository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
        if (user != null) {
            ModelAndView modelAndView = new ModelAndView("forward:/");
            modelAndView.addObject("user",user);
            modelAndView.addObject("error","");

            return modelAndView;
        } else {
            model.addAttribute("error", "Błędny login i/lub hasło");
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            modelAndView.addObject("error",model);
            return modelAndView;
        }
    }
}