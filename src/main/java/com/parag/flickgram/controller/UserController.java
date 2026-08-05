package com.parag.flickgram.controller;

import com.parag.flickgram.dto.UserRequestDTO;
import com.parag.flickgram.dto.UserResponseDTO;
import com.parag.flickgram.service.UserService;
import com.parag.flickgram.model.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping
    public List<User> getAllUsers(){
        return userservice.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
         Optional<User> user = userservice.getUser(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping
    public UserResponseDTO postUser(@Valid @RequestBody UserRequestDTO dto){
        return userservice.saveUser(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        User newUser = userservice.updateUser(id, user);

        if(newUser != null){
            return ResponseEntity.ok("User update");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not exist");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean userDeleted = userservice.deleteUser(id);

        if(userDeleted){
            return ResponseEntity.ok("User is deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not exist");
        }
    }

}
