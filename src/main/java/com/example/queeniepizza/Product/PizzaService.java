package com.example.queeniepizza.Product;

import com.example.queeniepizza.Product.Product;

import java.util.List;
import java.util.Map;

public interface PizzaService {
    List<Product> getAllPizzas();

    Product createOrder(Product pizza);

    Product getPizzaById(Long id);

    double calculateOrder(Map<Product, Integer> orderItems);

    Product updatePizza(Long id, Product pizza);
    void deletePizza(Long id);
}
