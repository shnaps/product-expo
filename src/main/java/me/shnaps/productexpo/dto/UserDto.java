package me.shnaps.productexpo.dto;

import me.shnaps.productexpo.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    @NotNull(message = "Name can't be null")
    @Size(min = 6, max = 25, message = "Name should be between 6 and 25 symbols")
    private String name;
    @NotNull(message = "Address can't be null")
    @Size(min = 10, max = 50, message = "Address must be between 10 and 50 symbols")
    private String address;
    @NotNull(message = "Email can't be null")
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User transform() {
        return new User(name, address, email);
    }
}
