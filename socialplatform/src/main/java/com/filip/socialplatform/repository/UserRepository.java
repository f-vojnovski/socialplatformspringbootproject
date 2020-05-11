package com.filip.socialplatform.repository;

import com.filip.socialplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT u FROM User u WHERE u.name LIKE CONCAT('%',:searchInput,'%') or " +
            "u.surname LIKE CONCAT('%',:searchInput,'%') or " +
            "u.username LIKE CONCAT('%',:searchInput,'%')")
    List<User> findUsersBySearching(@Param("searchInput") String searchInput);
}