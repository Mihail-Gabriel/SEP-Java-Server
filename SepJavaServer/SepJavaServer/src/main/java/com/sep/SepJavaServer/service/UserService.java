package com.sep.SepJavaServer.service;



import com.sep.SepDataClient.UserAuthenticationClient;
import com.sep.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    public UserService() {
    }

    @Override
    public User registerUser(String name, String password,String email, String address, String telephoneNo) {
        return null;
    }

    @Override
    public User loginUser(String email, String password) {
        UserAuthenticationClient userAuthenticationClient= new UserAuthenticationClient();
        return null;
    }

    @Override
    public void deleteUser(String email) {
        UserAuthenticationClient userAuthenticationClient= new UserAuthenticationClient();
    }

    @Override
    public User viewUser(String username) {
        UserAuthenticationClient userAuthenticationClient= new UserAuthenticationClient();
        return null;
    }
}
