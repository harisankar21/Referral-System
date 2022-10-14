package com.social.referral.controllers;

import com.social.referral.entities.User;
import com.social.referral.services.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value ="/user",method = RequestMethod.GET,produces = "application/json")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value ="/user",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public String AddUser(@RequestBody JSONObject jsonObject){
        return userService.addUser(jsonObject);
    }

}
