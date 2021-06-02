package com.sep.SepJavaServer.service;

import java.io.IOException;

public interface IFoodService {

    String getFood() throws IOException;
    String addFood(String foodList) throws IOException;
}
