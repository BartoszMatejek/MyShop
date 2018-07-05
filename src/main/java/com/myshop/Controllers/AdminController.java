package com.myshop.Controllers;

import com.myshop.Model.Admin;
import com.myshop.Model.LoginAdmin;
import com.myshop.Model.User;
import com.myshop.repositories.AdminRepository;
import com.myshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("loginAdmin", new LoginAdmin());
        return "admin";
    }
    @PostMapping("/admin")
    public String adminLogin(@ModelAttribute LoginAdmin loginAdmin, Model model) {
        Admin admin = adminRepository.findByLoginAndPassword(loginAdmin.getLogin(), loginAdmin.getPassword());
        if (admin != null) {
            return getHomePage(model);
        } else {
            model.addAttribute("error", "Błędny login i/lub hasło");
            return "admin";
        }
    }

    @GetMapping("/adminPanel")
    public String getHomePage(Model model){
        List<User> list = userRepository.findAllBy();
        model.addAttribute("listUsers", list);
        return "adminPanel";
    }
}
