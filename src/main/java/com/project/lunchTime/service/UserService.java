package com.project.lunchTime.service;

import com.project.lunchTime.model.User;
import com.project.lunchTime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(User user) {
        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
