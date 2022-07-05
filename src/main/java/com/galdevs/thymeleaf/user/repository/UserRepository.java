package com.galdevs.thymeleaf.user.repository;

import com.galdevs.thymeleaf.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
