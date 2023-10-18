package com.sjl22951227.onlineboard.post;

import com.sjl22951227.onlineboard.post.services.PostCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class PostController {

    private final PostCrudService postCrudService;

    public PostController(PostCrudService postCrudService) {
        this.postCrudService = postCrudService;
    }

    @GetMapping("/page={pageNumber}")
    public ResponseEntity<Map<String, Object>> getPosts(@PathVariable String pageNumber) {
        try {
            int pageNum = Integer.parseInt(pageNumber);
            Map<String, Object> response = postCrudService.getPosts(pageNum);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<Post> readPost(@PathVariable long id) {
        try {
            Post newPost = postCrudService.readPost(id);
            return new ResponseEntity<>(newPost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/post/posting")
    public ResponseEntity<Post> writePost(@RequestBody Post post) {
        try {
            Post newPost = postCrudService.writePost(post);
            return new ResponseEntity<>(newPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        try {

            Post existingPost = postCrudService.findPostById(id);

            if (existingPost == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Post newPost = postCrudService.updatePost(existingPost, post);

            return new ResponseEntity<>(newPost, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        return postCrudService.deletePost(id);
    }
}