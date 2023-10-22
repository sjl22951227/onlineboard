package com.sjl22951227.onlineboard.post.services;

import java.util.Map;

public interface PostSearchService {

    Map<String, Object> searchByKeyword(String keyword, int pageNumber, String type);
}
