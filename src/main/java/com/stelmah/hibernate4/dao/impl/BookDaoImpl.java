package com.stelmah.hibernate4.dao.impl;

import com.stelmah.hibernate4.dao.base.AbstractDao;
import com.stelmah.hibernate4.dao.api.BookDao;
import com.stelmah.hibernate4.model.Book;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl extends AbstractDao<Book, Integer> implements BookDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getByName(String value) {
        return (List<Book>) this.getSession().createCriteria(Book.class)
                .add(Restrictions.eq("name", value)).list();
    }
}
