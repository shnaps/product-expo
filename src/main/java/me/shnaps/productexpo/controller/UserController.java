package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    public static User finalUser;

    @PostMapping("/user")
    public String createUser(@Valid @RequestBody UserDto user) {
        finalUser = user.transform();
        return "User cached";
    }
}
