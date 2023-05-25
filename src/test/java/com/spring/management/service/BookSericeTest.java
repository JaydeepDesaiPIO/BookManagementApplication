package com.spring.management.service;

import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;
    @Autowired
    private BookServiceImpl bookSericeImpl;

    @BeforeEach
    void setup()
    {
        this.bookSericeImpl=new BookServiceImpl(this.bookRepo);
    }

    @Test
    void findByIdTest() {
        Books books=new Books("whatson","the man");
        Books books1=new Books("warner","the rich");
        Books books2=new Books("john","the poor");
        int id=1;
        when(bookRepo.findById(id)).thenReturn(
                Optional.of(books1));
        assertEquals(books1,bookSericeImpl.findById(id));

    }

    @Test
    void addBookTest()
    {
        Books books=new Books("whatson","the man");
        when(bookRepo.save(books)).thenReturn(books);
        assertEquals(books,bookSericeImpl.addBook(books));
    }

    @Test
    void getDataTest()
    {
        Books books=new Books("whatson","the man");
        Books books1=new Books("warner","the rich");
        Books books2=new Books("john","the poor");
        List<Books> list=List.of(books,books1,books2);
        when(bookRepo.findAll()).thenReturn(list);
        assertEquals(list,bookSericeImpl.getData());
    }

    @Test
    void updateTest()
    {
        Books books=new Books("whatson","the man");
        Books books1=new Books("warner","the rich");
        int id=0;
        Books b=bookRepo.findById(id).get();
        when(bookRepo.findById(id)).thenReturn(Optional.of(b));
        b.setBookName("Jungle Book");
        b.setAuthor("John");
        when(bookRepo.save(b)).thenReturn(b);
        assertEquals(b,bookSericeImpl.update(b,id));
    }
}