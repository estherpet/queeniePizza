package com.example.queeniepizza.Product;

import com.example.queeniepizza.Product.Product;
import com.example.queeniepizza.Product.PizzaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @PostMapping
    public Product createPizza(@RequestBody Product pizza) {
        return pizzaRepository.save(pizza);
    }

    @GetMapping
    public List<Product> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getPizzaById(@PathVariable Long id) throws Exception {
        return pizzaRepository.findById(id).orElseThrow(() -> new Exception(String.valueOf(id)));
    }

    @PutMapping("/{id}")
    public Product updatePizza(@PathVariable Long id, @RequestBody Product pizza) throws Exception {
        Product existingPizza = pizzaRepository.findById(id).orElseThrow(() -> new Exception(String.valueOf(id)));
        existingPizza.setPizzaName(pizza.getPizzaName());
        existingPizza.setPizzaSize(pizza.getPizzaSize());
        return existingPizza;
    }
}