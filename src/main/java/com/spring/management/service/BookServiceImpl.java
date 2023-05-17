package com.spring.management.service;

import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookSerice {

    @Autowired
    private BookRepo bookRepo;

    public void saveBook()
    {
        Books book=new Books();
        book.setAuthor("William");
        book.setBookName("Game of Throns");
        bookRepo.save(book);
    }

    //to find a book by id
    public Books findById(int id)
    {
        Books book=bookRepo.findById(id).get();
        return book;
    }

    public void saveBooks()
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

    //to delete a book by id
    public void DeleteByID(int id)
    {
        bookRepo.deleteById(id);
    }

    //to count number of rows in table
    public long Count()
    {
        long count=bookRepo.count();
        return count;
    }

    //to add new book to table
    public String addBook(Books b)
    {
         bookRepo.save(b);
         return "book added";
    }

    //get all books
    public List<Books> getData()
    {
        return bookRepo.findAll();
    }

    //Update data in table
    public void update(Books b,int id) {

        Books book= bookRepo.findById(id).get();

        book.setAuthor(b.getAuthor());
        book.setBookName(b.getBookName());
        bookRepo.save(book);
    }

}