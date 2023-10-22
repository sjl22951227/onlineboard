package com.sjl22951227.onlineboard.comment.repository;

import com.sjl22951227.onlineboard.comment.Comment;
import com.sjl22951227.onlineboard.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long postId);
    List<Comment> findByPostId(Long postId);
    void deleteAllByPostId(Long postId);
}
