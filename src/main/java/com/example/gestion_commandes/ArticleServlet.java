package com.example.gestion_commandes;

import dao.ArticleDao;
import dao.IArticleDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Article;
import models.ArticleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IArticleDao iArticleDao;

    public void init(){ iArticleDao = new ArticleDao(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String path = request.getServletPath();
        if(path.equals("/Article.do")){
            ArticleModel articleModel = new ArticleModel();
            List<Article> articles = this.iArticleDao.showAllArticle();
            articleModel.setArticles(articles);
            request.getRequestDispatcher("/Article/article.jsp").forward(request, response);
        }else if(path.equals("/AjouterArticle.do")){
            request.getRequestDispatcher("Article/add-article-form.jsp").forward(request, response);
        }else if(path.equals("/SaveArticle.do") && request.getMethod().equals("POST")){
            String libelle = request.getParameter("libelle");
            String category = request.getParameter("category");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            boolean state = Boolean.parseBoolean(request.getParameter("state"));
            this.iArticleDao.ajouterArticle(new Article(libelle,category,description,price,quantity,state));
            response.sendRedirect("Article.do");
        } else {
            int id;
            if (path.equals("/EditProduit.do")) {
                id = Integer.parseInt(request.getParameter("id"));
                Article article = this.iArticleDao.getArticle(id);
                request.setAttribute("article", article);
                request.setAttribute("id", id);
                request.getRequestDispatcher("Article/update-article-form.jsp").forward(request, response);
            } else if (path.equals("/UpdateArticle.do") && request.getMethod().equals("POST")) {
                id = Integer.parseInt(request.getParameter("id"));
                String libelle = request.getParameter("libelle");
                String category = request.getParameter("category");
                String description = request.getParameter("description");
                Double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                boolean state = Boolean.parseBoolean(request.getParameter("state"));
                Article article = new Article(libelle,category,description,price,quantity,state);
                article.setId(id);
                this.iArticleDao.updateArticle(article, id);
                response.sendRedirect("Article.do");
            } else if (path.equals("/SupprimerArticle.do")) {
                id = Integer.parseInt(request.getParameter("id"));
                this.iArticleDao.supprimerArticle(id);
                response.sendRedirect("Article.do");
            } else {
                request.getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        }

    }


}
