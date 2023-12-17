package com.ste.sdhapplication.usermodule.service;

import com.ste.sdhapplication.usermodule.model.UserModel;
import com.ste.sdhapplication.usermodule.repository.UserRepository;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserById(String userId) {
        return userRepository.findById(userId).orElse(new UserModel());
    }

    @Override
    public HashMap<String, String> createUser(UserModel userModel) {
        var createUserMap = new HashMap<String, String>();
        try {
            UserModel createdUser = userRepository.saveAndFlush(userModel);
            createUserMap.put("Status", "OK");
            createUserMap.put("Message", "User Created Successfully!");
            createUserMap.put("UserId", createdUser.getUserId());
            createUserMap.put("Error", null);
        } catch (Exception e) {
            createUserMap.put("Status", "KO");
            createUserMap.put("Message", "Error Creating User!");
            createUserMap.put("UserId", null);
            createUserMap.put("Error", e.getMessage());
        }
        return createUserMap;
    }

    @Override
    public HashMap<String, String> updateUser(String userId, UserModel userModel) {
        var updateUserMap = new HashMap<String, String>();
        userModel.setUserId(userId);
        try {
            UserModel createdUser = userRepository.saveAndFlush(userModel);
            updateUserMap.put("Status", "OK");
            updateUserMap.put("Message", "User Updated Successfully!");
            updateUserMap.put("Error", null);
        } catch (Exception e) {
            updateUserMap.put("Status", "KO");
            updateUserMap.put("Message", "Error Updating User!");
            updateUserMap.put("UserId", null);
            updateUserMap.put("Error", e.getMessage());
        }
        return updateUserMap;
    }

    @Override
    public HashMap<String, String> deleteUser(String id) {
        var deleteUserMap = new HashMap<String, String>();
        try {
            userRepository.deleteById(id);
            deleteUserMap.put("Status", "OK");
            deleteUserMap.put("Message", "User Deleted Successfully!");
            deleteUserMap.put("Error", null);
        } catch (Exception e) {
            deleteUserMap.put("Status", "KO");
            deleteUserMap.put("Message", "Error Deleting User!");
            deleteUserMap.put("UserId", null);
            deleteUserMap.put("Error", e.getMessage());
        }
        return deleteUserMap;
    }
}
