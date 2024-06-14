package com.itheima.service;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookService2TestCase {
    @Autowired
    BookService service;

    @Test
    void testGetById(){
        System.out.println(service.getById(3));
    }

    @Test
    void deleteById(){
        service.delete(3);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("Die Entscheidung");
        book.setDescription("Von Charlott Link");
        book.setType("Kriminalroman");
        service.save(book);
        System.out.println(service.getById(4));
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(4);
        book.setName("Die Entscheidung");
        book.setDescription("Charlott Link");
        book.setType("Kriminalroman");
        service.update(book);
        System.out.println(service.getById(4));
    }

    @Test
    void testGetAll(){
        for (Book book:
                service.getAll()) {
            System.out.println(book);
        }
    }


}
