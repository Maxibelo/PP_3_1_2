package com.example.PP_3_1_2.controller;

import com.example.PP_3_1_2.model.User;
import com.example.PP_3_1_2.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userServiceImp.findAll();
        model.addAttribute("users", users);
        return "usersList";
    }
    @GetMapping("/user-create")
    public String createUserForm(@ModelAttribute("user") User user){
        return "new";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userServiceImp.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userServiceImp.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @PostMapping("/user-update")
    public String updateUser(User user){
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }
}
