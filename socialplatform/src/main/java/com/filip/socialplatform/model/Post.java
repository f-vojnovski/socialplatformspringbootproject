package com.filip.socialplatform.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String content;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
