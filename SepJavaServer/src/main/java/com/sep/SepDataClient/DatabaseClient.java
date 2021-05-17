package com.sep.SepDataClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.sep.model.Users;
import com.sep.util.Request;;

import java.io.*;
import java.net.Socket;

import static com.sep.util.EventType.*;


public class DatabaseClient  {
    private final int PORT = 2910;
    private final String HOST = "localhost";
    private InputStream inFromSocket;
    private OutputStream outToSocket;
    private Socket clientSocket;
    private ObjectWriter ow;

    public DatabaseClient() {
        ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
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
    public String registerUser(String jsonBody) throws IOException {

        String jsonResponse = "";
        Gson gson = new Gson();
        Users user=gson.fromJson(jsonBody,Users.class);

        System.out.println();
        Request objToBeSentToDb= new Request(PLACEHOLDER_REQUEST_REGISTER_USER, user);

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
    public Users loginUser(String username, String password) throws IOException {
        String jsonLoginRequest;
        String jsonResponse = "";
        String requestForLogin = "username "+ username+ " password "+ password;

        Request objToBeSentToDb= new Request(PLACEHOLDER_REQUEST_LOGIN_USER, requestForLogin);

        jsonLoginRequest = ow.writeValueAsString(objToBeSentToDb);
        outToSocket.write(jsonLoginRequest.getBytes());
        System.out.println("Reguest to database --> "+jsonLoginRequest);

        ///END OF WRITING, START OF READING
        byte[] jsonByte = new byte[256];
        int bytesRead;
        do {
            bytesRead = inFromSocket.read(jsonByte);
            jsonResponse += new String(jsonByte,0,bytesRead);

        }
        while (inFromSocket.available() > 0);
        System.out.println("Received from DB: " + jsonResponse);

        Gson gson = new Gson();
        Users userLoggedin = gson.fromJson(jsonResponse,Users.class);
        return userLoggedin;
}


}
