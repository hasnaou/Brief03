package dao;

import models.Article;
import tools.TonConnection;

import java.io.PipedReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao implements IArticleDao{

    private static final String INSERT_ARTICLE = "INSERT INTO article (libelle, category, description, price, quantity, state) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ARTICLE_BY_ID = "SELECT id,libelle,category,description,price,quantity,state FROM article WHERE id=?;";
    private static final String SELECT_ARTICLES = "SELECT * FROM article;";
    private static final String DELETE_ARTICLE = "DELETE FROM article WHERE id = ?;";
    private static final String UPDATE_ARTICLE = "UPDATE article SET libelle = ?, category = ?, description = ?, price = ?, quantity = ?, state = ? WHERE id = ?;";

    public ArticleDao(){}

    @Override
    public Article ajouterArticle(Article article) {
        Connection connection = TonConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ARTICLE);
            preparedStatement.setString(1, article.getLibelle());
            preparedStatement.setString(2, article.getCategory());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setDouble(4, article.getPrice());
            preparedStatement.setInt(5,article.getQuantity());
            preparedStatement.setBoolean(6,article.getState());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> showAllArticle() {
        List<Article> articles = new ArrayList<>();
        Connection connection = TonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLES);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setLibelle(resultSet.getString("libelle"));
                article.setCategory(resultSet.getString("category"));
                article.setDescription(resultSet.getString("description"));
                article.setPrice(resultSet.getDouble("price"));
                article.setQuantity(resultSet.getInt("quantity"));
                article.setState(resultSet.getBoolean("state"));
                articles.add(article);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return articles;
    }

    @Override
    public Article getArticle(int id) {
        Article article = null;
        Connection connection = TonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                article = new Article();
                article.setLibelle(resultSet.getString("libelle"));
                article.setCategory(resultSet.getString("category"));
                article.setDescription(resultSet.getString("Description"));
                article.setPrice(resultSet.getDouble("price"));
                article.setQuantity(resultSet.getInt("quantity"));
                article.setState(resultSet.getBoolean("state"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article updateArticle(Article article, int id) {
        Connection connection = TonConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ARTICLE);
            preparedStatement.setString(1, article.getLibelle());
            preparedStatement.setString(2, article.getCategory());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setDouble(4, article.getPrice());
            preparedStatement.setInt(5,article.getQuantity());
            preparedStatement.setBoolean(6,article.getState());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public void supprimerArticle(int id) {
        Connection connection = TonConnection.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ARTICLE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
