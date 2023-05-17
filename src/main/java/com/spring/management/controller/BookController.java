package com.spring.management.controller;

import com.spring.management.model.Books;
import com.spring.management.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping("save")
    public void add()
    {
       bookService.saveBook();
       bookService.saveBooks();
    }

    @GetMapping("findById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Books findBookById ( @PathVariable("id") int id)
    {
            return bookService.findById(id);
    }

    @RequestMapping("count")
    public long count()
    {
        return bookService.Count();
    }

    @PostMapping("add")
    public String save(@RequestBody Books book)
    {
        return bookService.addBook(book);
    }

    @GetMapping("getbooks")
    public List<Books> get()
    {
        return bookService.getData();
    }

    @PutMapping("update/{id}")
    public void updateData(@RequestBody Books book,@PathVariable("id") int id)
    {
         bookService.update(book,id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") int id)
    {
        try {
            bookService.DeleteByID(id);
            return new ResponseEntity<>("Deleted Book" ,HttpStatus.NO_CONTENT);
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
