package com.sep.SepJavaServer.service;



import java.io.IOException;
import java.util.ArrayList;

public interface MessageService {
    String getMessage() throws IOException;
    void saveMessage(String message) throws IOException;
}
