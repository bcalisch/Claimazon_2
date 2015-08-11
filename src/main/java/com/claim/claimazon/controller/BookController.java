package com.claim.claimazon.controller;


import com.claim.claimazon.dao.BookDao;
import com.claim.claimazon.dao.BookDaoImpl;
import com.claim.claimazon.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class BookController {
    private BookDao bookDAO = new BookDaoImpl();

    @RequestMapping(value="/",method= RequestMethod.GET)
    public ArrayList<Book> getAllBooks(){
        return bookDAO.findAllBooks();

    }
}