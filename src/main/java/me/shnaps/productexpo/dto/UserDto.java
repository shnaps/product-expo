package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.User;

public class UserDto {
    private String name;
    private String address;
    private String email;

    public UserDto(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public User transform() {
        return new User(name, address, email);
    }
}
