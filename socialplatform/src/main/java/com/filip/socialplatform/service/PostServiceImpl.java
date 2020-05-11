package com.filip.socialplatform.service;

import com.filip.socialplatform.model.Comment;
import com.filip.socialplatform.model.Post;
import com.filip.socialplatform.model.User;
import com.filip.socialplatform.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(User user, Post post) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPostsByUser(User user) {
        return postRepository.getAllByUserId(user.getId());
    }

    @Override
    public void addComment(Comment comment, Post post, User user) {
        comment.setUser(user);
        post.addComment(comment);
    }

    @Override
    public List<Post> getAllPostsByFriends(User user) {
        List<Post> posts = new ArrayList<Post>();

        for (User friend : user.getFriends()) {
            posts.addAll(friend.getPosts());
        }

        return posts;
    }
}
