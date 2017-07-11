package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.ArticleDao;
import com.backend.domain.Article;

/**
 * Created by sophon on 7/8/17.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDAO;

    @Override
    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public synchronized boolean addArticle(Article article) {
        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            articleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}
