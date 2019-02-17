package com.example.demo.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "users")
public class UserResource {

    @GetMapping
    public List getUsers() {


        List<User> list = new ArrayList<>();

        User user1 = new User(1, "Joao");
        list.add(user1);

        User user2 = new User(2, "Maria");
        list.add(user2);


        return list;
    }


}
