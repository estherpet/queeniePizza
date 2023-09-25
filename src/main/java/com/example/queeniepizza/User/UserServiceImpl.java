package com.example.queeniepizza.User;
import com.example.queeniepizza.OrderPizza.OrderPizza;
import com.example.queeniepizza.OrderPizza.OrderPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final OrderPizzaRepository orderPizzaRepository;

    @Autowired
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository, OrderPizzaRepository orderPizzaRepository){
        this.userRepository = userRepository;
        this.orderPizzaRepository = orderPizzaRepository;
    }

    @Override
    public void register(RegisterRequest request) {
        validate(request.getUserName());
        User user = new User();
        user.setUserEmail(request.getEmail());
        user.setUserAddress(request.getAddress());
        user.setPhoneNumber(request.getPhonenumber());
        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        userRepository.save(user);
    }
    private void validate(String userName) {
        if (UserNameExist(userName))
            throw new IllegalArgumentException("User name already exist");
    }

    private boolean UserNameExist(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }

    @Override
    public void logIn(LogInRequest logInRequest) {
        User user = userRepository.findByUserName(logInRequest.getUsername());
        UserNameExist(logInRequest.getUsername());
        user.getPassword().equals(logInRequest.getPassword());

    }

    @Override
    public OrderPizza orderPizza(long userId, OrderPizza orderPizza) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            orderPizza.setUser(user);
            return orderPizzaRepository.save(orderPizza);
        } else {
            return null;
        }
    }
    @Override
    public List<OrderPizza> getOrderHistory(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return orderPizzaRepository.findByUser(user);
        } else {
            return Collections.emptyList();
        }
    }
    @Override
    public void changePassword(ChangePasswordRequest passwordRequest) {
        User user = userRepository.findByUserName(passwordRequest.getUserName());
        UserNameExist(passwordRequest.getUserName());
        if (user.getPassword().equals(passwordRequest.getOldPassword()))
            user.setPassword(passwordRequest.getNewPassword());
    }
}
