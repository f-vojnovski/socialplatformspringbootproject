package com.filip.socialplatform.service;

import com.filip.socialplatform.model.User;
import com.filip.socialplatform.repository.RoleRepository;
import com.filip.socialplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    @Override
    public boolean addFriend(User user1, User user2) {
        return user1.addFriend(user2);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllFriendsOfUser(User user) {
        return user.getFriends();
    }

    @Override
    public List<User> findUsersBySearching(String searchInput) {
        return userRepository.findUsersBySearching(searchInput);
    }
}
