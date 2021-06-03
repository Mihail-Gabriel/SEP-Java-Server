package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IBranchService;
import com.sep.SepJavaServer.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    IFoodService foodService;

    @GetMapping("/get")
    public String getFood() throws IOException {
        return foodService.getFood();
    }
    @GetMapping("/getById")
    public String getFoodById(int id) throws IOException {
        return foodService.getFoodById(id);
    }
    @PostMapping("/add")
    public String addFood(@RequestBody String jsonBody) throws IOException {

        return foodService.addFood(jsonBody);
    }
}
