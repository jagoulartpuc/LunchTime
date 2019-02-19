package com.project.lunchTime.service;

import com.project.lunchTime.model.Restaurant;
import com.project.lunchTime.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackOn = Exception.class)
    public void create(Restaurant restaurant) {
        repository.save(restaurant);
    }

    public List<Restaurant> findAll() {
        return repository.findAll();
    }
}
