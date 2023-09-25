package com.example.queeniepizza.ShoppingCart;

import com.example.queeniepizza.Product.Product;

import java.util.Map;

public interface ShoppingCartService {
    void clearCart();

    Map<Product,Integer> getCartContents();

    void addToCart(Product pizza, int quantity);

    void removeFromCart(Product pizza, int quantity);
}
