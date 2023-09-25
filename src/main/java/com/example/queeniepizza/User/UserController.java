package com.example.queeniepizza.User;

import com.example.queeniepizza.OrderPizza.OrderPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    private UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")

    public User getUserById(@PathVariable Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id :" + id));
    }
    @PostMapping

    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PutMapping("/{id}")

    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id :" + id));
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        return userRepository.save(existingUser);
    }
    @DeleteMapping("/{id}")

    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
    @PostMapping("/register")

    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);

    }
    @PostMapping("/login")

    public String loginUser(@RequestBody User user) throws Exception {
        User existingUser = (User) userRepository.findByUserEmailAndPassword(user.getUserEmail(), user.getPassword()).
                orElseThrow(() -> new Exception("User not found with email and password"));
        return "Login successful";
    }

    @GetMapping("/{userId}/order-history")
    public ResponseEntity<List<OrderPizza>> getOrderHistory(@PathVariable Long userId) {
        List<OrderPizza> orderHistory = userService.getOrderHistory(userId);
        if (orderHistory != null && !orderHistory.isEmpty()) {
            return ResponseEntity.ok(orderHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderPizza> createOrder(@PathVariable Long userId, @RequestBody OrderPizza order) {
        OrderPizza createdOrder = userService.orderPizza(userId, new OrderPizza());
        if (createdOrder != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}