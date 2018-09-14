package com.aws.devops.service;

import com.aws.devops.bean.Comment;
import com.aws.devops.bean.Post;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public Comment save(Comment comment);
    public List<Comment> findAll();
    public Optional<Comment> findById(Integer id);

}
