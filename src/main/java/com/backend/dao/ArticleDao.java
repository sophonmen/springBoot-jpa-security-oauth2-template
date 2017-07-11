package com.backend.dao;

import java.util.List;

import com.backend.domain.Article;

/**
 * Created by sophon on 7/8/17.
 */
public interface ArticleDao {
    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    void addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    boolean articleExists(String title, String category);
}