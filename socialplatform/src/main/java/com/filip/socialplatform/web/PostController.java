package com.filip.socialplatform.web;

import com.filip.socialplatform.model.Comment;
import com.filip.socialplatform.model.Post;
import com.filip.socialplatform.model.SearchInput;
import com.filip.socialplatform.model.User;
import com.filip.socialplatform.repository.UserRepository;
import com.filip.socialplatform.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@SessionAttributes({"currentUser"})
@CrossOrigin
public class PostController {
    private final PostService postService;

    private final UserRepository userRepository;

    @Autowired
    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @PostMapping("/newPost")
    public void createNewPost(@RequestBody Post post, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if (user == null) {
            return;
        }

        if (post == null) {
            return;
        }

        postService.addPost(user, post);
    }

    @RequestMapping(value = "/getMyPosts", method = RequestMethod.GET)
    public List<Post> getMyPosts(Principal principal) {
        if (principal == null) {
            return null;
        }
        User user = userRepository.findByUsername(principal.getName());
        if (user == null) {
            return null;
        }

        List<Post> posts = postService.getAllPostsByUser(user);

        return posts;
    }

    @RequestMapping(value = "/getPostsByUser", method = RequestMethod.POST)
    @ResponseBody
    public List<Post> getPostsByUser(@RequestBody SearchInput searchInput) {
        User user = userRepository.findByUsername(searchInput.getSearchInput());

        if (user == null) return null;

        List<Post> posts = postService.getAllPostsByUser(user);

        return posts;
    }

    @PostMapping("/addComment")
    public void addNewComment(@ModelAttribute("commentForm") Comment comment, Post post, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if (user == null) {
            return;
        }

        if (post == null) {
            return;
        }

        if (comment == null) {
            return;
        }

        postService.addComment(comment, post, user);
    }

    @GetMapping("showMyFeed")
    public List<Post> showMyFeed(Principal principal) {
        if (principal == null) return null;
        User user = userRepository.findByUsername(principal.getName());

        return postService.getAllPostsByFriends(user);
    }
}
