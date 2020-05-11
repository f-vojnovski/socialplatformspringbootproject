package com.filip.socialplatform.service;

import com.filip.socialplatform.repository.UserRepository;
import com.filip.socialplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userDAO;

    @Autowired
    public UserService(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }
}
