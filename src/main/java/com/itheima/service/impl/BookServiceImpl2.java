package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean save(Book book) {
        int lines = bookDao.insert(book);
        return lines > 0;
    }

    @Override
    public Boolean update(Book book) {
        int lines = bookDao.update(book, null);
        return lines > 0;
    }

    @Override
    public Boolean delete(Integer id) {

        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
