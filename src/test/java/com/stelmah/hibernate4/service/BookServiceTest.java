package com.stelmah.hibernate4.service;


import com.stelmah.hibernate4.configuration.RootConfiguration;
import com.stelmah.hibernate4.model.Book;
import com.stelmah.hibernate4.service.api.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfiguration.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookServiceTest {

    private static final String TEST_VALUE_1 = "test value 1";
    private static final String TEST_VALUE_2 = "test value 2";

    private static Logger LOG = LoggerFactory.getLogger(BookServiceTest.class);

    @Autowired
    private BookService bookService;


    @Test
    public void saveTest() {
        Book book = new Book();
        book.setName(TEST_VALUE_1);
        book.setSize(512);
        bookService.save(book);
    }


    @Test
    public void getAllTest() {
        List<Book> books = bookService.getAll();

        for (Book book : books) {
            if (book.getName().equals(TEST_VALUE_1)) {
            }
        }
    }

    @Test
    public void updateTest() {
        List<Book> books = bookService.getByValue(TEST_VALUE_1);
        if (books == null || books.size() == 0) {
            Assert.fail("NOT FOUND TEST VALUE 1");
        }
        Book book = books.get(0);
        book.setName(TEST_VALUE_2);
        bookService.update(book);
    }

    @Test
    public void deleteTest() {
        List<Book> books = bookService.getByValue(TEST_VALUE_2);
        if (books == null || books.size() == 0) {
            Assert.fail("NOT FOUND TEST_VALUE_2");
        }
        for (Book book: books) {
            bookService.delete(book);
        }
    }

}
