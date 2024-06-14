package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    BookDao bookDao;
    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(2));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("Die Entscheidung");
        book.setDescription("Charlott Link");
        book.setType("Kriminalroman");
        bookDao.insert(book);
        System.out.println(bookDao.selectById(3));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(3);
        book.setName("Die Entscheidung");
        book.setDescription("Charlott Link");
        book.setType("Kriminalroman");
        bookDao.updateById(book);
        System.out.println(bookDao.selectById(3));
    }

    @Test
    void testGetAll(){
        for (Book book:
                bookDao.selectList(null)) {
            System.out.println(book);
        }
    }

    @Test
    void testPage(){
        IPage pageConf = new Page(1,2);
        IPage<Book> page = bookDao.selectPage(pageConf, null);
        for(Object book : page.getRecords()){
            System.out.println(book);
        }
    }

    @Test
    void tetsGetByCondition(){
        String name = "Die Entscheidung";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        List<Book> books = bookDao.selectList(lqw);
        for(Book book : books){
            System.out.println(book);
        }
    }
}
