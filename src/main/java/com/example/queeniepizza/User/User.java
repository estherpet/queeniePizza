package com.example.queeniepizza.User;

import com.example.queeniepizza.OrderPizza.OrderPizza;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userId;
    private  int userRoleId;
    @Column(nullable = false)
    private  String userName;
    @Column(unique = true,nullable = false)
    private String phoneNumber;
    @Column(unique = true,nullable = false)
    private  String userEmail;
    @Column(nullable = false)
    private  String  userAddress;
    @Column(nullable = false)
    private String  password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<OrderPizza> orders;
}
