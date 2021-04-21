package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class MessageServiceImpl implements MessageService{


    DatabaseClient client= new DatabaseClient();

    public MessageServiceImpl() throws IOException {

    }

    @Override
    public String getMessage() throws IOException {

        return client.getMessageFromDb();
    }

    @Override
    public void saveMessage(String message) throws IOException {

       client.saveMessageToDb(message);

    }
}
