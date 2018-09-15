package com.aws.devops.bean;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
@Entity
@Table(name="comment")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "commentId")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_generator")
    @SequenceGenerator(name="comment_generator", sequenceName = "comment_seq")
    @Column(name="commentid")
    private int commentId;

    @Column(name="voicecontent")
    @JsonProperty("voicecontent")
    private String voicecontent;



    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "post_comment_id",nullable = false)
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment() {
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getVoicecontent() {
        return voicecontent;
    }

    public void setVoicecontent(String voicecontent) {
        this.voicecontent = voicecontent;
    }
}
