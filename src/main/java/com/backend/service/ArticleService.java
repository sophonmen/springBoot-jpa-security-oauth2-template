package com.backend.service;

import java.util.List;

import com.backend.domain.Article;

/**
 * Created by sophon on 7/8/17.
 */
public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    boolean addArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);
}


