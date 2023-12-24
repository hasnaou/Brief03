package models;

import java.util.ArrayList;
import java.util.List;

public class ArticleModel {
    private String mc;
    private List<Article> articles = new ArrayList();

    public ArticleModel() {
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
