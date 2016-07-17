package com.stelmah.hibernate4.service.api;

import com.stelmah.hibernate4.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAll();
    public void save(Book book);

    public void update(Book book);
    public void delete(Book book);

    public List<Book> getByValue(String value);
}
