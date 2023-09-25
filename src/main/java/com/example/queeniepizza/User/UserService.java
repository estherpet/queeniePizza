package com.example.queeniepizza.User;

import com.example.queeniepizza.OrderPizza.OrderPizza;

import java.util.List;

public interface UserService {
    void register(RegisterRequest request);
    void logIn(LogInRequest logInRequest);

    OrderPizza orderPizza(long userId, OrderPizza orderPizza);

    List<OrderPizza> getOrderHistory(Long userId);

    void changePassword(ChangePasswordRequest passwordRequest);

}
