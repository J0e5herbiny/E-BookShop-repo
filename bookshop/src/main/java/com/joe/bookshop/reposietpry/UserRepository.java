package com.joe.bookshop.reposietpry;

import com.joe.bookshop.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

//@Repository("userRepo")
public interface UserRepository extends JpaRepository<User, UUID> {
    void deleteById(int id);

    Optional<User> findById(int id);
}
