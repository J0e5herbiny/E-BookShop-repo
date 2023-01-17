package com.joe.bookshop.service;

import com.joe.bookshop.domain.dto.UserDTO;
import com.joe.bookshop.domain.model.User;
import com.joe.bookshop.reposietpry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

  //  @Override
    public List<User> getAll(){          // Read
        return userRepository.findAll();
    }

    public Optional<User> getById(int id){ // Read by id
        return userRepository.findById(id);
    }

    public void save(UserDTO userDTO){   // Create, Update
     User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
        user.setId(0);
   //  user.setId(user.getId());
        userRepository.save(user);

    }

    public String delete(int id){       // Delete
        userRepository.deleteById(id);
        return "Deleted";
    }

}
