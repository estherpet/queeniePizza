package com.example.queeniepizza.OrderPizza;
import com.example.queeniepizza.User.User;
import com.example.queeniepizza.OrderPizza.OrderPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface OrderPizzaRepository extends JpaRepository<OrderPizza,Long> {

    List<OrderPizza> findByUser(User user);
    List<OrderPizza> findByOrderCustomerId(int orderCustomerId);
}
