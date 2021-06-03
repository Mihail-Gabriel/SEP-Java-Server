package com.sep.SepJavaServer.service;

import com.sep.SepDataClient.DatabaseClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FoodService implements IFoodService{
    @Override
    public String getFood() throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.getFoodFromDB();
    }

    @Override
    public String getFoodById(int id) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.getFoodByIdFromDB(id);
    }

    @Override
    public String addFood(String food) throws IOException {
        DatabaseClient databaseClient= new DatabaseClient();
        return databaseClient.addFoodToDB(food);
    }
}
