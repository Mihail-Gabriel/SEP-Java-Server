package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IUserService;
import com.sep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public void register(@RequestBody String name, String email, String password, String address, String telephoneNo)
    {
        userService.registerUser(name,email,password,address,telephoneNo);
    }

    @GetMapping("/view")
    public User view(@RequestBody String email){
        User viewedUser = userService.viewUser(email);
        return viewedUser;
    }

    @GetMapping("/login")
    public User login(@RequestBody String email, String password){
        User loggedInUser = userService.loginUser(email,password);
        return loggedInUser;
    }

    @DeleteMapping("/delete")
        public void delete(@RequestBody String email){
        userService.deleteUser(email);
    }
}



