package com.aws.devops.controllers;

import com.aws.devops.bean.Comment;
import com.aws.devops.bean.Post;
import com.aws.devops.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping(value="/api/posts")
    public ResponseEntity<List<Post>> find(){
        System.out.println("get into the find method");
        List<Post> responsePostList = new ArrayList<>();
        List<Post> posts = postService.findAll();
        posts.forEach(n->System.out.println("xx"+n.getDescription()));
        for (int i = 0; i < posts.size(); i++) {
            Post pp = new Post();
            BeanUtils.copyProperties(posts.get(i), pp);
            responsePostList.add(pp);
        }
        return new ResponseEntity<List<Post>>(responsePostList, HttpStatus.OK);
    }

    /*@PutMapping(path = "/api/posts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> updateCommentByPostId(@Valid @RequestBody Post post, UriComponentsBuilder builder){

    }*/
    @PostMapping(path = "/api/posts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> createPost(@Valid @RequestBody Post post, UriComponentsBuilder builder){
        System.out.println("get into the save method");
        //postService.save(post);
        /*
        * {
            "description": "post01",
            "content": "010101",
            "comments":[{"voicecontent":"really good"}]
          }
        * */
        Post p = new Post();
        p.setDescription(post.getDescription());
        p.setContent(post.getContent());
        Comment c=null;
        List<Comment> commentlist = new ArrayList<Comment>();
        for(Comment element:post.getComments()){
            c=new Comment();
            c.setVoicecontent(element.getVoicecontent());
            c.setPost(p);
            commentlist.add(c);
        }
        p.setComments(commentlist);
        postService.save(p);
        HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(builder.path("/api/posts"));
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value="/api/posts/{postid}")
    public ResponseEntity<Post> findById(@PathVariable  String postid){
       //Post responsePost = new Post();
        Post responsePost = postService.findById(Integer.valueOf(postid)).get();
        return  new ResponseEntity<Post>(responsePost, HttpStatus.OK);
    }
    @PutMapping(path = "/api/posts/{postid}/comment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Post> createCommentById(@PathVariable  String postid,@Valid @RequestBody Comment comment){
        /**
         * put json
         * {"voicecontent":"fantastic"}
         * */
        Post updatePost = postService.findById(Integer.valueOf(postid)).get();
        comment.setPost(updatePost);
        updatePost.getComments().add(comment);
        postService.save(updatePost);
        return  new ResponseEntity<Post>(updatePost, HttpStatus.OK);
    }

    /*
    *delete the specific comment base on id
    */
    @DeleteMapping(path = "/api/posts/{postid}/comment/{commentid}")
    public ResponseEntity<Post> createCommentById(@PathVariable  String postid,@PathVariable String commentid){

        Post deletePost = postService.findById(Integer.valueOf(postid)).get();
        Integer commentIndex=0;
        for(Comment comment:deletePost.getComments()){
            if(commentid.equals(comment.getCommentId())){
               break;
            }else{
                commentIndex++;
            }
        }
        //ArrayList<Comment> deleteComment= new ArrayList(deletePost.getComments().stream().filter(c->c.getCommentId()!=Integer.valueOf(commentid)).collect(Collectors.toList()));
        deletePost.getComments().remove(commentIndex);
        postService.save(deletePost);
        return  new ResponseEntity<Post>(deletePost, HttpStatus.OK);
    }
}
