package com.sep.SepDataClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.sep.model.Users;
import com.sep.util.Request;;

import java.io.*;
import java.net.Socket;


import static com.sep.util.EventType.PLACEHOLDER_REQUEST;
import static com.sep.util.EventType.PLACEHOLDER_REQUEST_REGISTER_USER;


public class DatabaseClient  {
    private final int PORT = 2910;
    private final String HOST = "localhost";
    private InputStream inFromSocket;
    private OutputStream outToSocket;
    private Socket clientSocket;

    public DatabaseClient() {
        try {
            clientSocket = new Socket(HOST, PORT);
            inFromSocket = clientSocket.getInputStream();
            outToSocket = clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getMessageFromDb() throws IOException {

        String jsonResponse = "";

        Request objToBeSentToDb= new Request(PLACEHOLDER_REQUEST, "fffffffffff");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(objToBeSentToDb);

        outToSocket.write(json.getBytes());
        System.out.println("Reguest to database --> "+json);

        ///END OF WRITING, START OF READING
        byte[] jsonByte = new byte[256];
        int bytesRead;
        do {
            bytesRead = inFromSocket.read(jsonByte);
            jsonResponse += new String(jsonByte,0,bytesRead);

            }
        while (inFromSocket.available() > 0);
        System.out.println("Received from DB: " + jsonResponse);
        return jsonResponse;
    }
    public String registerUser(String username, String password, String address, String telephoneNo, String city, String role) throws IOException {

        String jsonResponse = "";
        Users user= new Users(username,password,address,telephoneNo,city,role);
        Request objToBeSentToDb= new Request(PLACEHOLDER_REQUEST_REGISTER_USER, user);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonUser = ow.writeValueAsString(objToBeSentToDb);

        outToSocket.write(jsonUser.getBytes());
        System.out.println("Reguest to database --> "+jsonUser);

        ///END OF WRITING, START OF READING
        byte[] jsonByte = new byte[256];
        int bytesRead;
        do {
            bytesRead = inFromSocket.read(jsonByte);
            jsonResponse += new String(jsonByte,0,bytesRead);

        }
        while (inFromSocket.available() > 0);
        System.out.println("Received from DB: " + jsonResponse);

        return jsonResponse;
    }



}
