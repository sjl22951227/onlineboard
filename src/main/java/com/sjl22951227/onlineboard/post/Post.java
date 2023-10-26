package com.sjl22951227.onlineboard.post;

import com.sjl22951227.onlineboard.User.User;
import com.sjl22951227.onlineboard.comment.Comment;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
//
//@Table(indexes = {
//        @Index(name = "index_views", columnList = "views", unique = false),
//        @Index(name = "index_created_time", columnList = "created_Time", unique = false)
//})

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 100, nullable = false)
    private String title;
//    @Column(length = 20, nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String text;
    @Column(nullable = false)
    private long views;
    @Column(nullable = false)
    private LocalDateTime created_Time;
    @Column
    private LocalDateTime modified_Time;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments=new ArrayList<>();

    public Post() {
    }

    public Post(String title, User author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.views = 0;
        this.created_Time = LocalDateTime.now();
        this.modified_Time = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public LocalDateTime getCreated_Time() {
        return created_Time;
    }

    public void setCreated_Time(LocalDateTime created_Time) {
        this.created_Time = created_Time;
    }

    public LocalDateTime getModified_Time() {
        return modified_Time;
    }

    public void setModified_Time(LocalDateTime modified_Time) {
        this.modified_Time = modified_Time;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
