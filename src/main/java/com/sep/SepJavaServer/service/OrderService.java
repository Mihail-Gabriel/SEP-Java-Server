package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderService implements IOrderService{
    @Override
    public String addOrder(String order) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.addOrderToDB(order);
    }

    @Override
    public String getOrderByUsername(String username) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.getOrderByUsernameDB(username);
    }
}
