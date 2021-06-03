package com.sep.SepJavaServer.service;

import java.io.IOException;

public interface IOrderService {
    String addOrder(String order) throws IOException;
    String getOrderByUsername(String username) throws IOException;
}
