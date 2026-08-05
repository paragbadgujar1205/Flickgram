package com.parag.flickgram.service;

import com.parag.flickgram.dto.UserRequestDTO;
import com.parag.flickgram.dto.UserResponseDTO;
import com.parag.flickgram.repository.UserRepository;
import com.parag.flickgram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    ---------Getting users--------------
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUser(Integer id){
        return userRepository.findById(id);

    }
//     ------------create user---------
    public UserResponseDTO saveUser(UserRequestDTO dto){
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(savedUser.getId());
        responseDTO.setName(savedUser.getName());
        responseDTO.setEmail(savedUser.getEmail());

        return responseDTO;
    }
//  --------------update user-----------

    public User updateUser(int id, User user){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();

            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());

            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
