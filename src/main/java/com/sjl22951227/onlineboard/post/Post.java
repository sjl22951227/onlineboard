package com.sjl22951227.onlineboard.post;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    @Column(length = 20, nullable = false)
    private String author;
    @Column(columnDefinition = "Text", nullable = false)
    private String text;
    @Column(nullable = false)
    private long views;
    @Column(nullable = false)
    private LocalDateTime created_Time;
    @Column(nullable = false)
    private LocalDateTime modified_Time;

    public Post() {
    }

    public Post(String title, String author, String text) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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
}
