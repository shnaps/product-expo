package me.shnaps.productexpo.repository;

import me.shnaps.productexpo.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User getUserByEmail(String email);
}
