package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService service;

    @GetMapping("/getmessage")
    public String getMessage() throws IOException {
        return service.getMessage();
    }

}
