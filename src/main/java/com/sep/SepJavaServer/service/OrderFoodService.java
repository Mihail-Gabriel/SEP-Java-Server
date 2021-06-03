package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderFoodService implements IOrderFoodService{
    @Override
    public String addOrderFood(String orderFood) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.addOrderFoodToDB(orderFood);
    }
}
