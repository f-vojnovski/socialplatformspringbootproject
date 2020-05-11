package com.filip.socialplatform.service;

import com.filip.socialplatform.model.Comment;
import com.filip.socialplatform.model.Post;
import com.filip.socialplatform.model.User;

import java.util.List;

public interface PostService {
    void addPost(User user, Post post);

    List<Post> getAllPostsByUser(User user);

    void addComment(Comment comment, Post post, User user);

    List<Post> getAllPostsByFriends(User user);
}
