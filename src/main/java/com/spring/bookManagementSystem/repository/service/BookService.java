package com.spring.bookManagementSystem.repository.service;

import com.spring.bookManagementSystem.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public void savebook()
    {
        Books book=new Books();
        book.setAuthor("William");
        book.setBookName("Game of Throns");
        bookRepo.save(book);
    }

    public void findByID()
    {
        int id=2;
        System.out.println(bookRepo.findById(id));
    }

    @PostConstruct
    public void savebooks()
    {

        Books book=new Books();
        book.setAuthor("Rollings");
        book.setBookName("Harry Potter");
        Books books=new Books();
        books.setAuthor("MTX");
        books.setBookName("Game of Rings");

        bookRepo.saveAll(List.of(book,books));
    }

    public void DeleteByID()
    {
        int id=3;
        bookRepo.deleteById(id);
    }

    public void Count()
    {
        long count=bookRepo.count();
        System.out.println(count);
    }

}
