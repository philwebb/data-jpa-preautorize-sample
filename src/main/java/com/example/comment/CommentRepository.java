package com.example.comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Override
    @PreAuthorize("#comment?.username == authentication?.name")
    Comment save(@Param("comment") Comment comment);
}
