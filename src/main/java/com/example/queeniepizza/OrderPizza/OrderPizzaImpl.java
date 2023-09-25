package com.example.queeniepizza.OrderPizza;

import com.example.queeniepizza.OrderPizza.OrderPizza;
import com.example.queeniepizza.OrderPizza.OrderPizzaRepository;
import com.example.queeniepizza.Product.PizzaRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPizzaImpl {
        @Autowired
        private OrderPizzaRepository orderPizzaRepository;

        @Autowired
        private PizzaRepository pizzaRepository;
//        public Order placeOrder(Order order) {
//            return orderPizzaRepository.save(order);
//        }

        public List<OrderPizza> getAllOrders() {
            return orderPizzaRepository.findAll();
        }

        public Order getOrderById(Long id) {
            return (Order) orderPizzaRepository.findById(id).orElse(null);
        }
}
