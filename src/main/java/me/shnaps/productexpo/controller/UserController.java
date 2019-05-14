package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    private static User finalUser;

    public static User getFinalUser() {
        return finalUser;
    }

    public static void setFinalUser(User finalUser) {
        UserController.finalUser = finalUser;
    }

    @PostMapping("/user")
    public String createUser(@Valid @RequestBody UserDto user) {
        setFinalUser(user.transform());
        return "User cached";
    }
}
