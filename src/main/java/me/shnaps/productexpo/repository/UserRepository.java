package me.shnaps.productexpo.repository;

import me.shnaps.productexpo.entity.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User getUserByEmail(String email);
}