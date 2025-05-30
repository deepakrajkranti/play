package com.starter.play.repository;

import com.starter.play.onetoOne.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}