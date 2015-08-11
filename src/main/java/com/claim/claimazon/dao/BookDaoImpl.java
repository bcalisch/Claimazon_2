package com.claim.claimazon.dao;


import com.claim.claimazon.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by benjamin on 8/10/15.
 */
public class BookDaoImpl implements BookDao {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Book> findAllBooks() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        ArrayList<Book> bookList = (ArrayList<Book>) session.createCriteria(Book.class);
        tx.commit();
        session.close();
        return bookList;
    }

    @Override
    public ArrayList<Book> findBookById(String id) {
        return null;
    }

    @Override
    public ArrayList<Book> findBooksByCategory(String name) {
        return null;
    }

    @Override
    public void updateBook(String id) {

    }

    @Override
    public String deleteBook(String id) {
        return null;
    }

    @Override
    public Boolean addBook(Book book) {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();

        return false;
    }
}