package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> users();

    Optional<User> user(String username);

}
