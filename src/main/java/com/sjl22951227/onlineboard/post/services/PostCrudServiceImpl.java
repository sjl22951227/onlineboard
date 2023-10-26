package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.comment.Comment;
import com.sjl22951227.onlineboard.comment.repository.CommentRepository;
import com.sjl22951227.onlineboard.exceptions.ResourceNotFoundException;
import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostCrudServiceImpl implements PostCrudService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostCrudServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @PostConstruct
    public void init() {
        //dummy 데이터 생성
//        if(postRepository.findAll().size()<300){
//            List<Post> initialPosts = new ArrayList<>();
//            for (int i = 1; i <= 100; i++) {
//                initialPosts.add(new Post("master의 게시물입니다! " + i, "master", "This is post from master(dummy posts) " + i));
//                initialPosts.add(new Post("저는 게스트입니다!!! " + i, "guest", "This is post from guest(dummy posts) " + i));
//                initialPosts.add(new Post("이승준의 게시물입니다! " + i, "sjl22", "This is post from sjl22(dummy posts) " + i));
//            }
//            postRepository.saveAll(initialPosts);
//        }
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
            Pageable pageable = PageRequest.of(pageNumber - 1, 20, Sort.by("id").descending());
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
    public Boolean deletePost(long id) {
        Optional<Post> post=postRepository.findById(id);
        if (post.isPresent()) {
            commentRepository.deleteAll(post.get().getComments());
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
