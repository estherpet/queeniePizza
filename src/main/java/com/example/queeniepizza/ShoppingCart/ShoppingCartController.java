package com.example.queeniepizza.ShoppingCart;

import com.example.queeniepizza.Product.Product;
import com.example.queeniepizza.Product.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RestController
@RequestMapping("/shopping-cart")
 public class ShoppingCartController {
        @Autowired
        private ShoppingCartService shoppingCartService;

        @Autowired
        private PizzaRepository pizzaRepository;

        @GetMapping("/view")
        public String viewCart(Model model) {
            Map<Product, Integer> cartContents = shoppingCartService.getCartContents();
            model.addAttribute("cartContents", cartContents);
            return "cart/view";
        }

        @PostMapping("/add")
        public String addToCart(@RequestParam Long pizzaId, @RequestParam int quantity) {
            pizzaRepository.findById(pizzaId).ifPresent(pizza -> shoppingCartService.addToCart(pizza, quantity));
            return "redirect:/cart/view";
        }

        @PostMapping("/remove")
        public String removeFromCart(@RequestParam Long pizzaId, @RequestParam int quantity) {
            pizzaRepository.findById(pizzaId).ifPresent(pizza -> shoppingCartService.removeFromCart(pizza, quantity));
            return "redirect:/cart/view";
        }

        @PostMapping("/clear")
        public String clearCart() {
            shoppingCartService.clearCart();
            return "redirect:/cart/view";
        }
    }
