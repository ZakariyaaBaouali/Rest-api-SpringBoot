package com.zakariabaouali.spring_rest.controllers;

import com.zakariabaouali.spring_rest.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private final String FOLDER_PATH = "C:\\Users\\PC\\Desktop\\Java\\spring-rest\\src\\main\\resources\\static\\";

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
    public String createUserAvatar(@RequestParam("file") MultipartFile file){
        String filePath = this.FOLDER_PATH  + file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath));
        }catch(Exception ex){
            return "cannot save the file";
        }
        return "file uploaded name : " + file.getOriginalFilename();
    }

    @GetMapping("/avatar/{avatar}")
    @ResponseStatus(HttpStatus.OK)
    public byte[] getUserAvatar(@PathVariable("avatar") String avatar){
        String filePath = this.FOLDER_PATH + avatar;
        byte[] image = null;
        try {
            image = Files.readAllBytes(new File(filePath).toPath());
        }catch (Exception ex){
            System.out.println("cannot get the file");
        }
        return image;
    }
}
