package com.example.queeniepizza.ShoppingCart;

import com.example.queeniepizza.Product.Product;
import com.example.queeniepizza.ShoppingCart.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

        private Map<Product, Integer> cart = new HashMap<>();
    @Override
        public void addToCart(Product pizza, int quantity) {
            cart.put(pizza, cart.getOrDefault(pizza, 0) + quantity);
        }
        @Override
        public void removeFromCart(Product pizza, int quantity) {
            int currentQuantity = cart.getOrDefault(pizza, 0);
            if (currentQuantity > quantity) {
                cart.put(pizza, currentQuantity - quantity);
            } else {
                cart.remove(pizza);
            }
        }
        @Override
        public Map<Product, Integer> getCartContents() {
            return cart;
        }
      @Override
        public void clearCart() {
            cart.clear();
        }
    }

