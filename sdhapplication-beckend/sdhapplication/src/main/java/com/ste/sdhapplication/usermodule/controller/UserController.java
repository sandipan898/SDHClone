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

    @PostMapping("/")
    public HashMap<String, String> create(@RequestBody final UserModel userModel) {
        logger.info("Accessing create() -> POST : api/v1/user/");
        return userService.createUser(userModel);
    }



    @DeleteMapping("/{userId}")
    public HashMap<String, String> delete(@PathVariable String userId) {
        logger.info("Accessing delete() -> DELETE : api/v1/user/");
        return userService.deleteUser(userId);
    }
}
