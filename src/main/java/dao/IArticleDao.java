package dao;

import models.Article;

import java.util.List;

public interface IArticleDao {
    Article ajouterArticle(Article article);

    List<Article> showAllArticle();

    Article getArticle(int id);

    Article updateArticle(Article article, int id);

    void supprimerArticle(int id);
}
