package com.spring.management.service;

import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Books findByID()
    {
        int id=2;
        Books list=bookRepo.findById(id).get();
        return list;
    }

    public void savebooks()
    {

        Books book=new Books();
        book.setAuthor("Rollings");
        book.setBookName("Harry Potter");
        Books books=new Books();
        books.setAuthor("MTX");
        books.setBookName("Game of Rings");

        bookRepo.saveAll(List.of(book,books));
        //System.out.println(abc);
    }

    public void DeleteByID()
    {
        int id=3;
        bookRepo.deleteById(id);
    }

    public long Count()
    {
        long count=bookRepo.count();
        return count;
    }



}
