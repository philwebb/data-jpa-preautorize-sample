package com.example.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Override
    Comment save(@Param("comment") Comment comment);
}
