package com.sjl22951227.onlineboard.comment.services;

import com.sjl22951227.onlineboard.comment.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentCrudService {
    ResponseEntity<Void> deleteComment(Long id);

    Comment addComment(Long postId, Comment comment);

    List<Comment> getComment(Long postId);

}
