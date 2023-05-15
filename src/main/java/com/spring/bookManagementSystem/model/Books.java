package com.spring.bookManagementSystem.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
//@Table(name = "Book_details")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Book_id")
    private int id;
    @Column(name="Author")
    private String author;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }

}
