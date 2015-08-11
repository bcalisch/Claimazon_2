package com.claim.claimazon.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author implements java.io.Serializable{
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> books = new ArrayList<>();

    public Author(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name="First_Name")
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="Last_Name")
    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthors", joinColumns = {@JoinColumn(name = "Books_ID")},
            inverseJoinColumns = {@JoinColumn(name = "Authors_ID")})
    public List<Book> getBooks() {
        return books;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }
}

