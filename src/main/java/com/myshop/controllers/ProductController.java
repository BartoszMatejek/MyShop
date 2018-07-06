package com.myshop.controllers;


import com.myshop.model.*;
import com.myshop.repositories.BoughtProductsRepository;
import com.myshop.repositories.ProductRepository;
import com.myshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BoughtProductsRepository boughtProductsRepository;
    @Autowired
    UserRepository userRepository;

    public User loggedUser;

    @GetMapping("logout")
    public String logout(){
       loggedUser = null;
       return "redirect:/login";
    }

    @PostMapping("/")
    public String getHomePage(Model model, User user){
        loggedUser = user;
        if (loggedUser == null)
        {
            return "redirect:/login";
        }
        List<Product> list = productRepository.findAllBy();
        HomeViewModel homeModel = new HomeViewModel(loggedUser,list,null);
        model.addAttribute("listProduct", homeModel);
        return "index";
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        if (loggedUser == null)
        {
            return "redirect:/login";
        }
        List<Product> list = productRepository.findAllBy();
        HomeViewModel homeModel = new HomeViewModel(loggedUser,list, null);
        model.addAttribute("listProduct", homeModel);
        return "index";
    }

    @GetMapping("/cart/{id}")
    public String showCart(Model model, @PathVariable("id") long id){
        if (loggedUser == null)
        {
            return "redirect:/login";
        }
            User user = userRepository.findByEmail(loggedUser.getEmail());
            Product product = productRepository.findById(id);
            model.addAttribute("product",product);
            return "cart";
    }

    @GetMapping("/confirmation/{id}")
    public String showConfirmation(Model model, @PathVariable("id") long id){
        if (loggedUser == null)
        {
            return "redirect:/login";
        }
        Product product = productRepository.findById(id);
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        User user = userRepository.findByEmail(loggedUser.getEmail());
        boughtProductsRepository.save(new BoughtProduct(product.getId(), formattedDate,user.getId()));
        model.addAttribute("product", product);
        return "confirmation";
    }

    @GetMapping("/history")
    public String getHistoryPage(Model model){
        if (loggedUser == null)
        {
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(loggedUser.getEmail());
        List<BoughtProduct> history = boughtProductsRepository.findBoughtProductsByUserId(user.getId());
        List<ProductViewModel> products = new ArrayList<>();

        for (BoughtProduct boughtProduct :history) {
            products.add(new ProductViewModel(productRepository.findById(boughtProduct.getProductId()), boughtProduct));
        }
        HomeViewModel homeModel = new HomeViewModel(loggedUser,null,products);

        model.addAttribute("productList", homeModel);

        return "history";
    }

    @GetMapping("mydata")
    public String getUserData(Model model){
        if(loggedUser == null){
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(loggedUser.getEmail());
        HomeViewModel homeViewModel = new HomeViewModel(user,null,null);
        model.addAttribute("user", homeViewModel);
        return "mydata";
    }
}
