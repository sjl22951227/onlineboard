package com.sjl22951227.onlineboard.comment;

import com.sjl22951227.onlineboard.post.Post;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String memberId;
    private String text;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    private LocalDateTime created_Time;

    public Comment() {
    }

    public Comment(String memberId, String text) {
        this.memberId = memberId;
        this.text = text;
        this.created_Time = LocalDateTime.now();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
