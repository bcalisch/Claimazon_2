package com.claim.claimazon.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {

    private Integer id;
    private String title;
    private double price;
    private String description;
    private String publisher;
    private String yearPublished;
    private String imageName;
    private int stockNum;
    private List<Author> authors = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public Book(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "Price")
    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "Publisher")
    public String getPublisher() {
        return publisher;
    }

    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "Year_Published")
    public String getYearPublished() {
        return yearPublished;
    }

    private void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Column(name = "ImageName")
    public String getImageName() {
        return imageName;
    }

    private void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Column(name = "Stock")
    public int getStockNum() {
        return stockNum;
    }

    private void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthors", joinColumns = {@JoinColumn(name = "Books_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Authors_ID")})
    public List<Author> getAuthors() {
        return authors;
    }

    private void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookCategory", joinColumns = {@JoinColumn(name = "Book_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Name")})
    public List<Category> getCategories() {
        return categories;
    }

    private void setCategories(List<Category> categories) {
        this.categories = categories;
    }


}
