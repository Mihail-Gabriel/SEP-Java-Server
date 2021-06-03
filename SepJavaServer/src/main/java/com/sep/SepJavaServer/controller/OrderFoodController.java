package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IOrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/orderfood")
public class OrderFoodController {

    @Autowired
    IOrderFoodService orderFoodService;

    @PostMapping("/add")
    public String addOrder(@RequestBody String jsonBody) throws IOException {

        return orderFoodService.addOrderFood(jsonBody);
    }
}
