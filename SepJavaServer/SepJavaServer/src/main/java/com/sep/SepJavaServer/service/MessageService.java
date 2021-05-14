package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;

import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class MessageService implements IMessageService {

    public MessageService() throws IOException {

    }

    @Override
    public String getMessage() throws IOException {
        System.out.println("in message service");
        DatabaseClient client = new DatabaseClient();
        return client.getMessageFromDb();
    }

    @Override
    public void saveMessage(String message) throws IOException {
        DatabaseClient client = new DatabaseClient();
        client.saveMessageToDb(message);

    }
}
