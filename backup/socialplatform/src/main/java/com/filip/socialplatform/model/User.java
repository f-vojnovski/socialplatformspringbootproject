package com.filip.socialplatform.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    private String name;
    private String surname;
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany
    private Set<Role> roles;
}
