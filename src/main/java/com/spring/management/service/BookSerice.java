package com.spring.management.service;

import com.spring.management.model.Books;

import java.util.List;

public interface BookSerice {
    public void saveBook();

    public void saveBooks();
    public Books findById(int id);

    public void DeleteByID(int id);

    public long Count();

    public Books addBook(Books b);

    public List<Books> getData();

    public Books update(Books b,int id);

}
