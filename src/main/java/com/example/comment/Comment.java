package com.example.comment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String message;

    public Comment() {

    }

    public Comment(final String username, final String message) {
        this.username = username;
        this.message = message;
    }
}
