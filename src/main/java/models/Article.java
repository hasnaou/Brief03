package models;

import java.util.Date;

public class Article {
    private int id;
    private String libelle;
    private String category;
    private String description;
    private double price;
    private int quantity;
    private boolean state;

    public Article() {}

    public Article(String libelle, String category, String description, double price, int quantity, boolean state) {
        this.libelle = libelle;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.state = state;
    }

    public Article(int id, String libelle, String category, String description, double price, int quantity, boolean state) {
        this.id = id;
        this.libelle = libelle;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.state = state;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean getState() { return state; }
    public void setState(boolean state) { this.state = state; }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\''+
                ", quantity='" + quantity + '\''+
                ", state=" + state +
                '}';
    }
}
