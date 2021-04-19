package com.sep.SepJavaServer.controller;

import com.sep.SepJavaServer.model.Message;
import com.sep.SepJavaServer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService service;

    @GetMapping("/getmessage")
    public Message getMessage(){
        return service.getMessage();
    }

    @PostMapping("/savemessage")
    public void saveMessage(@RequestBody Message message){
        service.saveMessage(message);
    }

}
