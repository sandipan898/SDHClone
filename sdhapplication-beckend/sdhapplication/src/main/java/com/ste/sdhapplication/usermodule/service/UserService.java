package com.ste.sdhapplication.usermodule.service;

import com.ste.sdhapplication.usermodule.model.UserModel;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<UserModel> getAllUser();
    UserModel getUserById(String userId);
    HashMap<String, String> createUser(UserModel userModel);
    HashMap<String, String> updateUser(String id, UserModel userModel);
    HashMap<String, String> deleteUser(String id);
    HashMap<String, String> loginUser(String username, String password);
}
