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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
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

//    @Test
//    void findByIdTest() {
//        int id=1;
//        Books b=new Books("john","");
//        when(bookRepo.findById(id)).thenReturn(
//                new Books("william", "the rich"));
//        assertEquals(b,bookSericeImpl.findById(id));
//
//    }

    @Test
    void addBookTest()
    {
        Books books=new Books("whatson","the man");
        when(bookRepo.save(books)).thenReturn(books);
        assertEquals(books,bookSericeImpl.addBook(books));
    }

    @Test
    void deleteTest()
    {
        Books books=new Books("whatson","the man");

    }
}