package com.spring.management.controller;

import com.spring.management.model.Books;
import com.spring.management.service.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class BookController {

    Logger logger=LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("save")
    public void add()
    {
       bookService.saveBook();
       bookService.saveBooks();
    }

    @GetMapping("findById/{id}")
   // @ResponseStatus(HttpStatus.NO_CONTENT)
    public Books findBookById ( @PathVariable("id") int id)
    {
        Books b=bookService.findById(id);
        logger.info("Books Details = "+b);
        return b;
    }

    @RequestMapping("count")
    public long count()
    {
        return bookService.Count();
    }

    @PostMapping("add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Books save(@RequestBody Books book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("getbooks")
    @PreAuthorize("hasRole('ROLE_NORMAL') or hasRole('ROLE_ADMIN')")
    public List<Books> get()
    {
        return bookService.getData();
    }

    @PutMapping("update/{id}")
    public Books updateData(@RequestBody Books books,@PathVariable("id") int id)
    {
         return bookService.update(books,id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") int id)
    {
        try {
            bookService.DeleteByID(id);
            return new ResponseEntity<>("Book Deleted",HttpStatus.NO_CONTENT);
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
