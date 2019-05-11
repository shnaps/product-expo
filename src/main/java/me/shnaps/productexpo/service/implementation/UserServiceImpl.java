package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.repository.UserRepository;
import me.shnaps.productexpo.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(@NonNull User user) {
        repository.save(user);
        return user;
    }

}
