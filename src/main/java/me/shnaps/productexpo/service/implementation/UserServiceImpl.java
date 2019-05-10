package me.shnaps.productexpo.service.implementation;

import me.shnaps.productexpo.entity.User;
import me.shnaps.productexpo.repository.UserRepository;
import me.shnaps.productexpo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
