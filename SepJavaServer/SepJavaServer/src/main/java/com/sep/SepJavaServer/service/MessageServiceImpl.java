package com.sep.SepJavaServer.service;

import com.sep.SepJavaServer.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    Message message = new Message("default content");
    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public void saveMessage(Message message) {
        this.message = message;
    }
}
