package com.example.ecommerce.service;

public sealed interface OpenService permits OpenServiceImpl {
    boolean isUsernameUnique(String username);
}
