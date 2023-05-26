package com.spring.management.service;

import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookSerice {

    @Autowired
    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public void saveBook()
    {
        Books book=new Books();
        book.setAuthor("William");
        book.setBookName("Game of Throns");
        bookRepo.save(book);
    }

    //to find a book by id
    @Override
    public Books findById(int id)
    {
        return bookRepo.findById(id).get();
    }

    @Override
    public void saveBooks()
    {
        Books book=new Books();
        book.setAuthor("Rollings");
        book.setBookName("Harry Potter");
        Books books=new Books();
        books.setAuthor("MTX");
        books.setBookName("Game of Rings");
        bookRepo.saveAll(List.of(book,books));

    }

    //to delete a book by id
    @Override
    public void DeleteByID(int id)
    {
        bookRepo.deleteById(id);
    }

    //to count number of rows in table
    @Override
    public long Count()
    {
        return bookRepo.count();
    }

    //to add new book to table
    @Override
    public Books addBook(Books b)
    {
         bookRepo.save(b);
        // return "book added";
        return b;
    }

    //get all books
    @Override
//    @Scheduled(fixedDelay = 1000)
    public List<Books> getData()
    {
        List<Books> books=bookRepo.findAll();
        return books;
    }

    //Update data in table
    @Override
    public Books update(Books b,int id) {

        Books book= bookRepo.findById(id).get();

        book.setAuthor(b.getAuthor());
        book.setBookName(b.getBookName());
        bookRepo.save(book);
        return book;
    }
/*
    @PostConstruct
    @Scheduled(initialDelay = 10000,fixedDelay = 5000)
    public void Schedular() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Testing Schedular "+(new Date()));
    }

 */

//    @PostConstruct
//    //sec min hour dayOfMonth month dayOfWeek
//    @Scheduled(cron = "*/2 * * * * *")
//    public void SchedularCorn()
//    {
//        System.out.println("Testing App "+(new Date()));
//    }


}
