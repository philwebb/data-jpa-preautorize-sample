package com.example;

import com.example.comment.Comment;
import com.example.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DataJpaPreAuthorizeApplication implements CommandLineRunner {

    @Autowired
    private CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataJpaPreAuthorizeApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Arrays.asList("dhubau", "gregturn", "ogierke")
                .forEach((username) -> commentRepository.save(new Comment(username, "foo")));
    }
}
