package com.sep.SepJavaServer.service;



import com.sep.SepDataClient.DatabaseClient;
import com.sep.model.Users;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService implements IUserService{

    public UserService() {
    }

    @Override
    public String registerUser(String jsonBody) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.registerUser(jsonBody);
    }

    @Override
    public Users loginUser(String username, String password) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.loginUser(username,password);
    }

    @Override
    public void deleteUser(String email) {
        DatabaseClient databaseClient= new DatabaseClient();
    }

    @Override
    public Users viewUser(String username) {
        DatabaseClient databaseClient= new DatabaseClient();
        return null;
    }
}
