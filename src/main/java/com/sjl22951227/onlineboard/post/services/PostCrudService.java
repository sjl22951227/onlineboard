package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PostCrudService {

    Post findPostById(Long id);
    Map<String, Object> getPosts(int pageNum);
    Post readPost(long id);
    Post writePost(Post post);
    Post updatePost(Post existingPost, Post post);
    ResponseEntity<Void> deletePost(long id);
    void init();
}
