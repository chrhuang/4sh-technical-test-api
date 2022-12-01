package com.example.demo.controllers;

import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @GetMapping("index")
    public List<Article> index() {
        return articleService.index();
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article) {
        return articleService.update(id, article);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return articleService.delete(id);
    }
}
