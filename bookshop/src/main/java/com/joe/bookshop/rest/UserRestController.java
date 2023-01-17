package com.joe.bookshop.rest;

import com.joe.bookshop.domain.dto.UserDTO;
import com.joe.bookshop.domain.model.User;
import com.joe.bookshop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserServiceImpl userService;

    @Autowired
    public UserRestController(UserServiceImpl userService){
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUsr(@PathVariable("id") Integer id){
        Optional<User> user = userService.getById(id);
        UserDTO userDTO = new UserDTO(user.get().getFirstName(), user.get().getLastName(), user.get().getEmail());
        return userDTO;
    }

    @PostMapping("/user")
    public UserDTO addUsr(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
        return userDTO;
    }

}
