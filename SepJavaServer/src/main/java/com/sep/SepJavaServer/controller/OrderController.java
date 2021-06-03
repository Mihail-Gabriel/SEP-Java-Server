package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/add")
    public String addOrder(@RequestBody String jsonBody) throws IOException {

        return orderService.addOrder(jsonBody);
    }
    @GetMapping("/getByUsername")
    public String getFoodById(String username) throws IOException {
        return orderService.getOrderByUsername(username);
    }
}
