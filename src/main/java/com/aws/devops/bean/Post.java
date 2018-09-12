package com.aws.devops.bean;
//https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="post")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "postId")
/* JsonIdentityInfo
 * for OneToMany relation, need to add the @JsonIgnore,other wise will encounter jackson-bidirectional-relationships-and-infinite-recursion
 * */
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name="post_generator", sequenceName = "post_seq")
    @Column(name="postid")
    private int postId;
    @Column(name="description")
    private String description;
    @Temporal(TemporalType.TIME)
    @Column(name="creation_time")
    private Date creationTime;
    @Column(name="content")
    private String content;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("commentId asc")

    @JsonProperty("comments")
    @JsonIgnore
    private List<Comment> comments;
    /*
    * for OneToMany relation, need to add the @JsonIgnore,other wise will encounter jackson-bidirectional-relationships-and-infinite-recursion
    * */

    @PrePersist
    protected void onCreate() {
        if (creationTime == null) { creationTime = new Date(); }
    }
    public Post(int postId, String description, Date creationTime, String content, List<Comment> comments) {
        this.postId = postId;
        this.description = description;
        this.creationTime = creationTime;
        this.content = content;
        this.comments = comments;
    }

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

