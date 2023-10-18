package com.sjl22951227.onlineboard.post.services;

import com.sjl22951227.onlineboard.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostSearchService {
    Page<Post> searchByTitle(String keyword, Pageable pageable);
//    Page<Post> searchByAuthor(String author);
//    Page<Post> searchByText(String text);
}
