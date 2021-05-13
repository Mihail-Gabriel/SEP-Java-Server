package com.sep.SepDataClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sep.util.Request;;

import java.io.*;
import java.net.Socket;


import static com.sep.util.EventType.PLACEHOLDER_REQUEST;


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
        System.out.println("in db client");


        System.out.println("before conn");
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
            System.out.println("oidhjofdoifdiofiiiiiiiiiiiiii");
            }
        while (inFromSocket.available() > 0);
        System.out.println("Received from DB: " + jsonResponse);
        return jsonResponse;
    }

    public void saveMessageToDb(String message) throws IOException {

        String jsonRequest = "savemessage" + " " + message;
        String jsonResponse = "";

        outToSocket.write(jsonRequest.getBytes());
        System.out.println(jsonRequest);


        System.out.println("Received from DB: " + jsonResponse);


    }

}
