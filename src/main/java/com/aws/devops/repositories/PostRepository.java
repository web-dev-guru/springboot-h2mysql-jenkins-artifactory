package com.aws.devops.repositories;

import com.aws.devops.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
