package com.galdevs.thymeleaf.user.repository;

import com.galdevs.thymeleaf.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAllByUsername(String username);

    void deleteUserByUsername(String username);

    boolean existsByUsername(String username);
}
