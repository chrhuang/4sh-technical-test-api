package com.example.demo.services;

import com.example.demo.models.Article;

import java.util.List;

public interface ArticleService {
    Article create(Article article);
    List<Article> index();
    Article update(Long id, Article article);

    String delete(Long id);
}
