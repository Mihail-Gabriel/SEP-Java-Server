package com.sep.SepJavaServer.service;

import com.sep.SepJavaServer.model.Message;

public interface MessageService {
    Message getMessage();
    void saveMessage(Message message);
}
