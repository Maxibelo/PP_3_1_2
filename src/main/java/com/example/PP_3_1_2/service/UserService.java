package com.example.PP_3_1_2.service;

import com.example.PP_3_1_2.model.User;
import java.util.List;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

    public User saveUser(User user);

    public void deleteById (Long id);

}