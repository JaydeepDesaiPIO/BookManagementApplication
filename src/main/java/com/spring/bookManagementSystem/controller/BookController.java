package com.spring.bookManagementSystem.controller;

import com.spring.bookManagementSystem.repository.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


//    public void add()
//    {
//        bookService.savebook();
//        bookService.savebooks();
//    }
//

}
