package com.sep.SepJavaServer.service;

import com.sep.model.Users;

import java.io.IOException;

public interface IUserService {
    String registerUser(String jsonBody) throws IOException;
    Users loginUser(String username, String password) throws IOException;
    void deleteUser(String username);
    Users viewUser(String username);
}
