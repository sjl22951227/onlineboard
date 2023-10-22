package com.sjl22951227.onlineboard.comment.services;

import com.sjl22951227.onlineboard.comment.Comment;
import com.sjl22951227.onlineboard.comment.repository.CommentRepository;
import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentCrudServiceImpl implements CommentCrudService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public CommentCrudServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getComment(Long postId) {
        List<Comment> commentList = commentRepository.findByPostId(postId);
        if(!commentList.isEmpty()){
            return commentList;
        }
        else{
            return null;
        }
    }

    @Override
    public ResponseEntity<Void> deleteComment(Long id) {
        if(commentRepository.existsById(id)){

            Comment comment=commentRepository.findById(id).get();

            Post post=comment.getPost();

            post.setCommentsCounter(post.getCommentsCounter()-1);

            commentRepository.delete(comment);

            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found

        }
    }

    @Override
    public Comment addComment(Long postId, Comment comment) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            comment.setPost(post);

            System.out.println("comment: " + comment.getUser());

            post.setCommentsCounter(post.getCommentsCounter() + 1);
            return commentRepository.save(comment);
        }
        else{
            return null;
        }
    }
}