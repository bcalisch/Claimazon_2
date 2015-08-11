package com.claim.claimazon.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category implements java.io.Serializable{

    public Category(){}

    private String name;
    private List<Book> books = new ArrayList<>();

    @Id
    @Column(name = "Name", nullable = false)
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookCategory", joinColumns = {@JoinColumn(name = "Name")},
            inverseJoinColumns = {@JoinColumn(name = "Book_ID")})
    public List<Book> getBooks() {
        return books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }
}