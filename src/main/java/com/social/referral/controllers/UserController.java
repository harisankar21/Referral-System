package com.social.referral.controllers;
import com.social.referral.dto.UserDTO;
import com.social.referral.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value ="/user",produces = "application/json")
    public List<UserDTO> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping(value ="/user/{id}",produces = "application/json")
    public UserDTO getAllUser(@PathVariable(value = "id") Integer id){
        return userService.getUser(id);
    }

    @PostMapping(value ="/user",consumes = "application/json")
    public String AddUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    @PutMapping(value="/user", consumes = "application/json")
    public String UpdateUser(@RequestBody UserDTO user) throws Exception {
        return userService.updateUser(user);
    }


}
