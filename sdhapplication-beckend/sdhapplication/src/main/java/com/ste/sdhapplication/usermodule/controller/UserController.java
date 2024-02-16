package com.ste.sdhapplication.usermodule.controller;

import com.ste.sdhapplication.usermodule.model.UserModel;
import com.ste.sdhapplication.usermodule.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public List<UserModel> list() {
        logger.info("Accessing list() -> GET : api/v1/user/");
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public UserModel getById(@PathVariable String userId) {
        logger.info("Accessing getById() -> GET : api/v1/user/{userId}");
        return userService.getUserById(userId);
    }

    @GetMapping("/login")
    public HashMap<String, String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info("Accessing getById() -> GET : api/v1/user/login");
        return userService.loginUser(username, password);
    }

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final UserModel userModel) {
        logger.info("Accessing create() -> POST : api/v1/user/");
        return userService.createUser(userModel);
    }

    @PutMapping("/{userId}")
    public HashMap<String, String> update(@PathVariable String userId, @RequestBody final UserModel userModel) {
        logger.info("Accessing update() -> PUT : api/v1/user/{userId}");
        return userService.updateUser(userId, userModel);
    }

    @DeleteMapping("/{userId}")
    public HashMap<String, String> delete(@PathVariable String userId) {
        logger.info("Accessing delete() -> DELETE : api/v1/user/{userId}");
        return userService.deleteUser(userId);
    }
}
