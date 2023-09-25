package com.example.queeniepizza.OrderPizza;
import com.example.queeniepizza.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderPizza")
@Builder
public class OrderPizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int orderId;
    @NotBlank(message = "order type required")
    private  String orderType;
    @NotBlank(message = "order description required")
    private  String orderDescription;
    private String OrderNumber;
    private int orderCustomerId;
    private double totalAmount;
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
