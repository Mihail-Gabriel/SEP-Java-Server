package com.sep.SepDataClient;

import java.io.*;
import java.net.Socket;

public class Connection {
    private final int PORT = 2910;
    private final String HOST = "localhost";
    private InputStream inFromSocket;
    private OutputStream outToSocket;
    private Socket clientSocket;

    public Connection() {

        try {
            clientSocket = new Socket(HOST, PORT);
            inFromSocket = new ObjectInputStream(clientSocket.getInputStream());
            outToSocket = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInFromSocket() {
        return inFromSocket;
    }

    public OutputStream getOutToSocket() {
        return outToSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }
}
