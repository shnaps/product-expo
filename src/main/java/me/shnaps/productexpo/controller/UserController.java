package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public static User finalUser;

    @PostMapping("/user")
    public String createUser(@RequestBody UserDto user) {
        finalUser = user.transform();
        return "User cached";
    }
}
