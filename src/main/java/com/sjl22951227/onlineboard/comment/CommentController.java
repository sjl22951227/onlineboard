package com.sjl22951227.onlineboard.comment;

import com.sjl22951227.onlineboard.comment.repository.CommentRepository;
import com.sjl22951227.onlineboard.comment.services.CommentCrudService;
import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentCrudService commentCrudService;

    public CommentController(CommentCrudService commentCrudService) {
        this.commentCrudService = commentCrudService;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable Long postId) {
        List<Comment> commentList = commentCrudService.getComment(postId);
        if (commentList != null) {
            return new ResponseEntity<>(commentList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        Comment newComment = commentCrudService.addComment(postId, comment);
        if (newComment != null) {

            return new ResponseEntity<>(newComment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        return commentCrudService.deleteComment(id);
    }
}
