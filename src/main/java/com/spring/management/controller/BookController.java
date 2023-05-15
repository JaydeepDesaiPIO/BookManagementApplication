package com.spring.management.controller;

import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import com.spring.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("save")
    public void add()
    {
       bookService.savebook();
       bookService.savebooks();
    }

    @RequestMapping("findByID")
    public Books findBookById()
    {
        return bookService.findByID();
    }

    @RequestMapping("count")
    public long count()
    {
        return bookService.Count();
    }
}
