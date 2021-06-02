package com.sep.SepDataClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sep.model.Branch;
import com.sep.model.Food;
import com.sep.model.Users;
import com.sep.util.Request;;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        System.out.println(user.toString());
        Request objToBeSentToDb= new Request(REGISTER_REQUEST, user);

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
    public Users loginUser(String usernamePassword) throws IOException {
        String jsonLoginRequest;
        String jsonResponse = "";

        String[] userPass = usernamePassword.split(" ");

        String requestForLogin = "username "+ userPass[0]+ " password "+ userPass[1];

        Request objToBeSentToDb= new Request(LOGIN_REQUEST, requestForLogin);

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


    public String getAllBranchesFromDB() throws IOException {
        String jsonRequest;
        String jsonResponse = "";
        Request allBranchesRequest= new Request(BRANCHES_GET_REQUEST, null);


        jsonRequest = ow.writeValueAsString(allBranchesRequest);
        outToSocket.write(jsonRequest.getBytes());
        System.out.println("Reguest to database --> "+jsonRequest);

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

    public Branch getBranchFromDB(int id) throws IOException {
        String jsonRequest;
        String jsonResponse = "";
        Request branchRequest= new Request(BRANCH_GET_REQUEST, id);

        jsonRequest = ow.writeValueAsString(branchRequest);
        outToSocket.write(jsonRequest.getBytes());
        System.out.println("Reguest to database --> "+jsonRequest);

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
        Branch b = gson.fromJson(jsonResponse,Branch.class);
        return b;
    }

    public String addBranchToDB(String jsonBody) throws IOException {

        String jsonResponse = "";

        Gson gson = new Gson();
        Branch b = gson.fromJson(jsonBody,Branch.class);
        Request objToBeSentToDb= new Request(BRANCH_CREATE_REQUEST, b);

        String requestJson = ow.writeValueAsString(objToBeSentToDb);

        outToSocket.write(requestJson.getBytes());
        System.out.println("Reguest to database --> "+requestJson);

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
public String removeBranchFromDB(int id) throws IOException {
    String jsonRequest;
    String jsonResponse = "";
    Request branchRequest= new Request(BRANCH_REMOVE_REQUEST, id);

    jsonRequest = ow.writeValueAsString(branchRequest);
    outToSocket.write(jsonRequest.getBytes());
    System.out.println("Reguest to database --> "+jsonRequest);

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

    public String getFoodFromDB() throws IOException {
        String jsonRequest;
        String jsonResponse = "";
        Request foodRequest= new Request(FOOD_GET_REQUEST, null);

        jsonRequest = ow.writeValueAsString(foodRequest);
        outToSocket.write(jsonRequest.getBytes());
        System.out.println("Reguest to database --> "+jsonRequest);

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
    public String getFoodByIdFromDB(int id) throws IOException {
        List<Food> listResponse = new ArrayList<>();
        Gson gson= new Gson();
        String allFood = getFoodFromDB();


        final ObjectMapper objectMapper = new ObjectMapper();
        List<Food> fromJsonList = objectMapper.readValue(allFood, new TypeReference<List<Food>>(){});

        for(int i= 0;i<fromJsonList.size();i++)
        {
            if (fromJsonList.get(i).getBranch().getBranchId()==id)
            {
                listResponse.add(fromJsonList.get(i));
            }
        }
        return gson.toJson(listResponse);
    }
    public String addFoodToDB(String food) throws IOException {
        String jsonResponse = "";

        Gson gson = new Gson();
        Food food1 = gson.fromJson(food, Food.class);


        Request foodRequest = new Request(FOOD_ADD_REQUEST, food1);

        String requestJson = ow.writeValueAsString(foodRequest);

        outToSocket.write(requestJson.getBytes());
        System.out.println("Reguest to database --> "+requestJson);

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
