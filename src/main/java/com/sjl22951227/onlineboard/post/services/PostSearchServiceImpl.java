package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostSearchServiceImpl implements PostSearchService {

    private final PostRepository postRepository;

    public PostSearchServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Map<String, Object> searchByKeyword(String keyword, int pageNumber, String type) {
        Map<String, Object> response = new HashMap<>();

        try {
            Pageable pageable = PageRequest.of(pageNumber - 1, 20, Sort.by("id").descending());
            Page<Post> pagePosts = switch (type) {
                case "text" -> postRepository.findByTextContaining(keyword, pageable);
                case "author" -> postRepository.findByAuthorContaining(keyword, pageable);
                default -> postRepository.findByTitleContaining(keyword, pageable);
            };

            System.out.println("log: "+pagePosts.getTotalElements());

            response.put("content", pagePosts.getContent());
            response.put("totalPages", pagePosts.getTotalPages());

        } catch (
                Exception e) {
            throw new RuntimeException("Error when getPosts is running");
        }
        return response;
    }
}
