package com.asj.bootcamp.repository;

import com.asj.bootcamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean findByMailAndPassword(String email, String password);

    Optional<User> findByMail(String email);

}