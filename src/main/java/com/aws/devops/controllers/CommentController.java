package com.aws.devops.controllers;

import com.aws.devops.bean.Comment;
import com.aws.devops.bean.Post;
import com.aws.devops.service.CommentService;
import com.aws.devops.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
public class CommentController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @PutMapping(value="/api/comments/{commentid}/posts/{postid}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Comment> findCommentById(@PathVariable String commentid,@PathVariable String postid,@RequestBody Comment comment){
        //Post responsePost = new Post();
        Post responsePost = postService.findById(Integer.valueOf(postid)).get();
        Boolean isPostExist = postService.isPostExist(Integer.valueOf(postid));
        Optional<Comment> Optioncomment = commentService.findById(Integer.valueOf(commentid));
        Optioncomment.get().setVoicecontent(comment.getVoicecontent());
        postService.save(responsePost);
//asdf
        return  new ResponseEntity<Comment>(Optioncomment.get(), HttpStatus.OK);
    }

}
