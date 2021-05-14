package com.sep.SepJavaServer.service;

import com.sep.model.Users;

import java.io.IOException;

public interface IUserService {
    String registerUser(String username, String password, String address, String telephoneNo, String city, String role) throws IOException;
    Users loginUser(String username, String password);
    void deleteUser(String username);
    Users viewUser(String username);
}
