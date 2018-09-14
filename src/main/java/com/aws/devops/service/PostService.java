package com.aws.devops.service;

import com.aws.devops.bean.Post;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostService {
    public Post save(Post post);
    public List<Post> findAll();
    public Optional<Post> findById(Integer id);
    public Boolean isPostExist(Integer id);
}
