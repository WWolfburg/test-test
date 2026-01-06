package com.LL.login_WWolfburg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/orders")
public class OrdersController {

    @GetMapping
    public String getOrders(Model model) {
        return "Orders";
    }
}
