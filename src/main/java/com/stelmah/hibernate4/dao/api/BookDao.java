package com.stelmah.hibernate4.dao.api;

import com.stelmah.hibernate4.dao.base.GenericDao;
import com.stelmah.hibernate4.model.Book;

import java.util.List;

public interface BookDao extends GenericDao<Book, Integer> {

    public List<Book> getByName(String value);
}
