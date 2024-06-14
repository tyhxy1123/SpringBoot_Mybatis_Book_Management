package com.itheima.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    IBookService service;

    @Test
    void testGetById(){
        System.out.println(service.getById(3));
    }

    @Test
    void testDelete(){
        String name = "Die Entscheidung";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        service.remove(lqw);
        System.out.println(service.list());
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("Die Entscheidung");
        book.setDescription("Von Charlott Link");
        book.setType("Kriminalroman");
        service.save(book);

    }

    @Test
    void testUpdateCondition(){
        Book book = new Book();
        book.setName("Die Entscheidung");
        book.setDescription("Charlott Link");
        book.setType("Kriminalroman");
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(book.getName() != null, Book::getName, book.getName());
        service.update(book, lqw);
        System.out.println(service.list());
    }

    @Test
    void testGetAll(){
        for (Book book:
                service.list()) {
            System.out.println(book);
        }
    }

}
