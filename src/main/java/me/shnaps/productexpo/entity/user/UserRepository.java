package me.shnaps.productexpo.entity.user;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User getUserByEmail(String email);
}
