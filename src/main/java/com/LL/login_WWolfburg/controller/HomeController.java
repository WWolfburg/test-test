package com.LL.login_WWolfburg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.LL.login_WWolfburg.service.ProductService;



@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "Home-products";
    }
    
    
}
