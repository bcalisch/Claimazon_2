package com.claim.claimazon.dao;


import com.claim.claimazon.model.Book;

import java.util.ArrayList;


public interface BookDao {
    public ArrayList<Book> findAllBooks();
    public ArrayList<Book> findBookById(String id);
    public ArrayList<Book> findBooksByCategory(String name);
    public void updateBook(String id);
    public String deleteBook(String id);
    public Boolean addBook(Book book);
}
