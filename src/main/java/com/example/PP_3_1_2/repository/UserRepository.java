package com.example.PP_3_1_2.repository;

import com.example.PP_3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
