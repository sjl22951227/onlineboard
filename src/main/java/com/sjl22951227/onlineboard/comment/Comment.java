package com.sjl22951227.onlineboard.comment;

import com.sjl22951227.onlineboard.post.Post;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String user;
    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    private LocalDateTime created_Time;

    public Comment() {
    }

    public Comment(String user, String text) {
        this.user = user;
        this.text = text;
        this.created_Time = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
