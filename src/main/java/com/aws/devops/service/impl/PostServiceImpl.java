package com.aws.devops.service.impl;

import com.aws.devops.bean.Post;
import com.aws.devops.repositories.PostRepository;
import com.aws.devops.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(Integer id){
        Optional<Post> post = postRepository.findById(id);
        return post;
    }

    public List<Post> findAll(){
        List<Post> p = postRepository.findAll();
        return p;
    }

}
