package com.example;

import com.example.comment.Comment;
import com.example.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;

@SpringBootApplication
public class DataJpaPreAuthorizeApplication implements CommandLineRunner {

    @Autowired
    private CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataJpaPreAuthorizeApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        SecurityContext ctx = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.setContext(ctx);
        ctx.setAuthentication(new UsernamePasswordAuthenticationToken("dhubau", "password", Collections.singletonList(new SimpleGrantedAuthority("USER"))));
        commentRepository.save(new Comment("dhubau", "foo"));
        SecurityContextHolder.clearContext();
    }
}
