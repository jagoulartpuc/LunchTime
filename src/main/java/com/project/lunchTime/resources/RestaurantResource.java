package com.project.lunchTime.resources;


import com.project.lunchTime.model.Restaurant;
import com.project.lunchTime.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/restaurants")
public class RestaurantResource {

    private RestaurantService service;

    @Autowired
    public RestaurantResource(RestaurantService service) {
        this.service = service;
    }

    @GetMapping
    public List<Restaurant> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/test/{id}")
    public String test(@PathVariable("id") String txt) {
        return "test".concat(txt);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Restaurant restaurant) {
        service.create(restaurant);
    }


}
