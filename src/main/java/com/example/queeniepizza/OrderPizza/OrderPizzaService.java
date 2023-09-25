package com.example.queeniepizza.OrderPizza;

import com.example.queeniepizza.OrderPizza.OrderPizza;

import java.util.List;

public interface OrderPizzaService {


    List<OrderPizza> getAllOrders();

    void placeOrder(OrderPizza order);
}
