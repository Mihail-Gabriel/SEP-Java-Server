package com.sep.SepDataClient;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.io.*;
import java.net.Socket;



public class DatabaseClient  {
    private final int PORT = 4444;
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

        String jsonRequest = "getmessage";
        String jsonResponse = "";
        outToSocket.write(jsonRequest.getBytes());
        System.out.println(jsonRequest);

        byte[] jsonByte = new byte[256];
        int bytesRead;
        do {
            try {
                bytesRead = inFromSocket.read(jsonByte);
                jsonResponse += new String(jsonByte, 0, bytesRead);
            }
            catch
            (IOException e) {
                e.printStackTrace();
            }
        } while (inFromSocket.available() > 0);
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
