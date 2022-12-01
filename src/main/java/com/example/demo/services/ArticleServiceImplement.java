package com.example.demo.services;

import com.example.demo.models.Article;
import com.example.demo.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImplement implements ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @Override
    public Article update(Long id, Article article) {
        return articleRepository.findById(id)
                .map(a-> {
                    a.setName(article.getName());
                    a.setDescription(article.getDescription());
                    a.setPrice(article.getPrice());
                    return articleRepository.save(a);
                }).orElseThrow(() -> new RuntimeException("Article non trouvé !"));
    }

    @Override
    public String delete(Long id) {
        articleRepository.deleteById(id);
        return "Article supprimé";
    }
}
