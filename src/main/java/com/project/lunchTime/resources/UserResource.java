package com.project.lunchTime.resources;


import com.project.lunchTime.model.User;
import com.project.lunchTime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    //Vai para tela principal do CRUD aonde são listados todos os usuarios
    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/users");
        modelAndView.addObject("users", service.findAll());

        return modelAndView;
    }

    //Vai para tela de novo usuario
    @GetMapping("/new-user")
    public ModelAndView newUser(User user) {

        //createUser e o nome do aquivo html
        ModelAndView modelAndView = new ModelAndView("/createUser");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView create(User user) {

        service.create(user);

        return findAll();
    }


}
