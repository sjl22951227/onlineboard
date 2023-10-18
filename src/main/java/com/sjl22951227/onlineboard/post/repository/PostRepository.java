package com.sjl22951227.onlineboard.post.repository;

import com.sjl22951227.onlineboard.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
    List<Post> findByAuthorContaining(String author);
    List<Post> findByTextContaining(String text);
}
