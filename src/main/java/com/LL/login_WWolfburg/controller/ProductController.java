package com.LL.login_WWolfburg.controller;

import com.LL.login_WWolfburg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> 
            model.addAttribute("product", product)
        );
        return "Product-details";
    }
}
