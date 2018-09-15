package com.aws.devops.service.impl;

import com.aws.devops.bean.Comment;
import com.aws.devops.bean.Post;
import com.aws.devops.repositories.CommentRepository;
import com.aws.devops.repositories.PostRepository;
import com.aws.devops.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment;

    }
    public void delete(Integer index){

    }

}
