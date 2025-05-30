package com.starter.play.repository;

import com.starter.play.oneToMany.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}
