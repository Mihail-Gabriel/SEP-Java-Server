package com.sep.SepJavaServer.service;

import com.sep.model.User;

public interface IUserService {
    User registerUser(String name, String password,String email, String address, String telephoneNo);
    User loginUser(String email, String password);
    void deleteUser(String email);
    User viewUser(String email);
}
