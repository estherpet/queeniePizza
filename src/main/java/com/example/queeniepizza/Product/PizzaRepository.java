package com.example.queeniepizza.Product;

import com.example.queeniepizza.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PizzaRepository extends JpaRepository<Product,Long> {

}
