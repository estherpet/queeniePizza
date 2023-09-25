package com.example.queeniepizza.Product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String pizzaName;
    private String pizzaDescription;
    private  double price;
    private  String pizzaSize;


}
