package com.example.PP_3_1_2.service;

import com.example.PP_3_1_2.model.User;
import com.example.PP_3_1_2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public void deleteById (Long id){
        userRepository.deleteById(id);
    }
}
