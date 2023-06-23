package com.example.ecommerce.service;

import com.example.ecommerce.entity.UserProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserProfileService {
    List<UserProfile> userProfiles();
    Optional<UserProfile> userProfile(Long id);
    void delete(Long id);

    UserProfile save(UserProfile userProfile);

}
