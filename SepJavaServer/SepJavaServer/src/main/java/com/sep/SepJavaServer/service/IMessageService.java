package com.sep.SepJavaServer.service;



import java.io.IOException;


public interface IMessageService {
    String getMessage() throws IOException;
    void saveMessage(String message) throws IOException;
}
