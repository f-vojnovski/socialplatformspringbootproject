package com.filip.socialplatform.service;

import com.filip.socialplatform.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    boolean addFriend(User user1, User user2);

    User findUserByUsername(String username);

    List<User> findAllFriendsOfUser (User user);

    List<User> findUsersBySearching (String searchInput);
}
