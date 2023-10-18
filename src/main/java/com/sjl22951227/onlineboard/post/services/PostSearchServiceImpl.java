package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.post.Post;
import com.sjl22951227.onlineboard.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostSearchServiceImpl implements PostSearchService{

    private final PostRepository postRepository;

    public PostSearchServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> searchByTitle(String keyword, Pageable pageable) {
        return postRepository.findByTitleContaining(keyword, pageable);
    }

//    @Override
//    public Page<Post> searchByAuthor(String author) {
//        return postRepository.findByTitleContaining("keyword");
//    }
//
//    @Override
//    public Page<Post> searchByText(String text) {
//        return postRepository.findByTitleContaining("keyword");
//    }
}
