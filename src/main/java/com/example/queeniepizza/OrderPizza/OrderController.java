package com.example.queeniepizza.OrderPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

        private final OrderPizzaService orderService;

    public OrderController(OrderPizzaService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
        public String placeOrder(@ModelAttribute("order") OrderPizza order) {
            orderService.placeOrder(order);
            return "redirect:/order/all";
        }

        @GetMapping("/all")
        public String getAllOrders(Model model) {
            List<OrderPizza> orders = orderService.getAllOrders();
            model.addAttribute("orders", orders);
            return "order-list";
        }
    }


