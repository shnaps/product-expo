package me.shnaps.productexpo.entity;

import me.shnaps.productexpo.dto.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Name can't be null")
    @Size(max = 25, min = 6, message = "Name should be between 6 and 25 symbols")
    private String name;
    @NotNull(message = "Address can't be null")
    @Size(min = 10, max = 50, message = "Address must be between 10 and 50 symbols")
    private String address;
    @NotNull(message = "Email can't be null")
    @Column(unique = true)
    @Email
    private String email;

    public User() {
    }

    public User(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDto transformToDto() {
        return new UserDto(this.name, this.address, this.email);
    }
}
