package com.sep.SepJavaServer.service;

import java.io.IOException;

public interface IFoodService {

    String getFood() throws IOException;
    String getFoodById(int id) throws IOException;
    String addFood(String food) throws IOException;
}
