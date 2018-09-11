package com.aws.devops.repositories;

import com.aws.devops.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
