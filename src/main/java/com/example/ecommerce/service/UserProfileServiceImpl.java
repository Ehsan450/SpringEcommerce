package com.example.ecommerce.service;

import com.example.ecommerce.entity.UserProfile;
import com.example.ecommerce.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public List<UserProfile> userProfiles() {
        return userProfileRepository.findAll();
    }

    @Override
    public Optional<UserProfile> userProfile(Long id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userProfileRepository.deleteById(id);

    }

    @Override
    public UserProfile save(UserProfile userProfile) {
       return userProfileRepository.saveAndFlush(userProfile);
    }
}
