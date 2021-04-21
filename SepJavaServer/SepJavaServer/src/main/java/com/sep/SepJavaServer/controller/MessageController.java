package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService service;


    @GetMapping("/getmessage")
    public String getMessage() throws IOException {

        return service.getMessage();
    }

    @PostMapping("/savemessage")
    public void saveMessage(@RequestBody String message) throws IOException {
        service.saveMessage(message);


    }

}
