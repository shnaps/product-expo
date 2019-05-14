package me.shnaps.productexpo.controller;

import me.shnaps.productexpo.dto.UserDto;
import me.shnaps.productexpo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createUser(@Valid @RequestBody UserDto user) {
        setFinalUser(user.transform());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User with email ");
        String email = finalUser.getEmail();
        stringBuilder.append(email, 0, 2);
        stringBuilder.append("***");
        stringBuilder.append(email.substring(email.length() - 6));
        stringBuilder.append(" cached");
        return new ResponseEntity(stringBuilder.toString(), HttpStatus.OK);
    }
}
