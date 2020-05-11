package com.filip.socialplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;

    @Transient
    private String passwordConfirm;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @ManyToMany
    private Set<Role> roles;

    @ManyToMany
    private List<User> friends;

    @OneToMany
    private List<Post> posts;

    public boolean hasFriend(User user) {
        return friends.contains(user);
    }

    public boolean addFriend(User user) {
        if (this.hasFriend(user)) return false;
        this.friends.add(user);
        user.friends.add(this);
        return true;
    }
}