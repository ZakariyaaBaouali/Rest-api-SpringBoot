package com.zakariabaouali.spring_rest.controllers;

import com.zakariabaouali.spring_rest.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

@RestController
public class UserController {

    //get all users
    @GetMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<String> getUsers() {
        var users = new ArrayList<String>();
        users.add("tom halland");
        users.add("zak maroki");
        return users;
    }

    //create new user
    @PostMapping("/api/v1/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO payload){
        return  payload;
    }


    //get user with id
    @GetMapping("/api/v1/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getUserByID(@PathVariable("id") String id){
        return "user id : " + id;
    }

    ///api/v1/users/filter?filterBy=name
    @GetMapping("/api/v1/users/filter")
    @ResponseStatus(HttpStatus.OK)
    public String filterUsers(@RequestParam() String filterBy){
        return "this query should filter by : " + filterBy;
    }

    //api/v1/users/profile
}
