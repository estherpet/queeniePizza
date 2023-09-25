package com.example.queeniepizza.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PizzaServiceImpl implements PizzaService {

private final PizzaRepository pizzaRepository;


    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
@Override
    public List<Product> getAllPizzas() {
            return pizzaRepository.findAll();
        }
    @Override
    public Product createOrder(Product pizza) {
        return pizzaRepository.save(pizza);
    }
    @Override
    public Product getPizzaById(Long id){
        return pizzaRepository.findById(id).orElse(null);
    }
    @Override
    public double calculateOrder(Map<Product, Integer> orderItems) {
        double totalAmount = 0.0;
        for (Map.Entry<Product,Integer> entry: orderItems.entrySet()){
            Product pizza = entry.getKey();
            int quantity = entry.getValue();
            if (pizza != null && quantity > 0){
                double price = pizza.getPrice();
                totalAmount += price * quantity;
            }
        }
        return totalAmount;
    }
    @Override
    public Product updatePizza(Long id, Product updatedPizza) {
        Product existingPizza = pizzaRepository.findById(id).orElse(null);

        if (existingPizza != null) {
            existingPizza.setPizzaName(updatedPizza.getPizzaName());
            existingPizza.setPrice(updatedPizza.getPrice());
            return pizzaRepository.save(existingPizza);
        } else {
            return null;
        }
    }
    @Override
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}


