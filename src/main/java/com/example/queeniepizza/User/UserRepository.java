package com.example.queeniepizza.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long> {

    User findByUserName(String userName);

    Optional<Object> findByUserEmailAndPassword(String userEmail, String password);
}
