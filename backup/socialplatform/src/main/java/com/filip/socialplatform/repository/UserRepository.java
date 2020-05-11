package com.filip.socialplatform.repository;

import com.filip.socialplatform.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    int addUser(User user);

    List<User> selectAllUsers();

    Optional<User> selectUserById(Long id);

    int deleteUserByID(Long id);
}
