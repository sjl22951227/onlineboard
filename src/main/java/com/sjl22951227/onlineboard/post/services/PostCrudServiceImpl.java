package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.exceptions.ResourceNotFoundException;
import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostCrudServiceImpl implements PostCrudService {

    private final PostRepository postRepository;

    public PostCrudServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init() {
//        List<Post> initialPosts = new ArrayList<>();
//        for (int i = 1; i <= 104; i++) {
//            initialPosts.add(new Post("Title " + i, "sjl22", "This is post " + i));
//        }
//        postRepository.saveAll(initialPosts);
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> getPosts(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("pageNumber must be greater than 0");
        }

        Map<String, Object> response = new HashMap<>();

        try {
            Pageable pageable = PageRequest.of(pageNumber - 1, 20);
            Page<Post> pagePosts = postRepository.findAll(pageable);

            response.put("content", pagePosts.getContent());
            response.put("totalPages", pagePosts.getTotalPages());
        } catch (Exception e) {
            throw new RuntimeException("Error when getPosts is running");
        }
        return response;
    }

    @Override
    public Post readPost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        post.setViews(post.getViews() + 1);
        postRepository.save(post);
        return post;
    }

    @Override
    public Post writePost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Post is null");
        }
        Post newPost = new Post(post.getTitle(), post.getAuthor(), post.getText());
        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Post existingPost, Post post) {
        existingPost.setTitle(post.getTitle());
        existingPost.setAuthor(post.getAuthor());
        existingPost.setText(post.getText());
        existingPost.setModified_Time(LocalDateTime.now());

        postRepository.save(existingPost);
        return existingPost;
    }

    @Override
    public ResponseEntity<Void> deletePost(long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

}
