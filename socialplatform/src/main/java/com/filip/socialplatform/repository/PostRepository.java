package com.filip.socialplatform.repository;

import com.filip.socialplatform.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getAllByUserId(Long userId);
}
