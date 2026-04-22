package com.praktikumDB.deploy.service;

import com.praktikumDB.deploy.model.User;
import com.praktikumDB.deploy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository UserRepository;

    public UserService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public User addUser(User request) {
        return UserRepository.save(request);
    }

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public User getUserById(String id) {
        return UserRepository.findById(id).orElse(null);
    }

    public void deleteUser(String id) {
        UserRepository.deleteById(id);
    }

    public User updateUser(String id, User request){
        User existingUser = UserRepository.findById(id).orElse(null);
        if(existingUser != null) {
            existingUser.setName(request.getName());
            existingUser.setNim(request.getNim());
            return UserRepository.save(existingUser);
        }
        return null;
    }


}
