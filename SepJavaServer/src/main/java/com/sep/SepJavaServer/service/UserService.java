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
    public String registerUser(String username, String password, String address, String telephoneNo, String city, String role) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.registerUser(username,password,address,telephoneNo,city,role);
    }

    @Override
    public Users loginUser(String email, String password) {
        DatabaseClient databaseClient= new DatabaseClient();

        return null;
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
