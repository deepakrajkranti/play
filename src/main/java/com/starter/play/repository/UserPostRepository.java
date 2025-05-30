package com.starter.play.repository;

import com.starter.play.oneToMany.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostRepository extends JpaRepository<User,Long> {
}
