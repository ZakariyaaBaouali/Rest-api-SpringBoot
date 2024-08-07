package com.zakariabaouali.spring_rest.controllers;

import com.zakariabaouali.spring_rest.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    //get all users
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<String> getUsers() {
        var users = new ArrayList<String>();
        users.add("tom halland");
        users.add("zak maroki");
        return users;
    }

    //create new user
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestBody UserDTO payload){
        return  payload;
    }


    //get user with id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getUserByID(@PathVariable("id") String id){
        return "user id : " + id;
    }

    ///api/v1/users/filter?filterBy=name
    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public String filterUsers(@RequestParam() String filterBy){
        return "this query should filter by : " + filterBy;
    }

    //api/v1/users/avatar
    @PostMapping("/avatar")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUserAvatar(@RequestParam("file") MultipartFile file) throws Exception{
        return "file uploaded name : " + file.getOriginalFilename();
    }

    @GetMapping("/avatars/{avatar}")
    @ResponseStatus(HttpStatus.OK)
    public void getUserAvatar(@PathVariable("avatar") String avatar){
        //
    }
}
