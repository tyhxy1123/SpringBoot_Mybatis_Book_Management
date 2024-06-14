package com.itheima.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.controller.utils.Result;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController{
    private final IBookService bookService;

    @GetMapping
    public Result getAll(){
        return new Result(true, bookService.list());
    }

    @GetMapping("{name}")
    public Result getByName(@PathVariable String name){
        return new Result(true, bookService.getByName(name));
    }

    @GetMapping("{current}/{size}")
    public Result getPages(@PathVariable Integer current, @PathVariable Integer size, Book book){

        IPage<Book> pageConfig = new Page<>(current, size);
        IPage<Book> page = bookService.page(pageConfig);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        bookService.page(pageConfig, lqw);

        boolean flag = page != null;
        if(flag){
            if(current > page.getPages()){

                page = bookService.page(new Page<>(page.getPages(), size), lqw);
            }
            return new Result(flag, page, "Daten erfolgreich herausgezogen");
        }
        else{
            return new Result(flag, "Fehler beim Daten-Laden");
        }
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException{
        boolean erfolg = bookService.save(book);
        if(erfolg){
            return new Result(erfolg, "Neues Buch hinzugefügt");
        }else {
            return new Result(erfolg, "Datei-Speichern geshceitert");
        }
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        if(book == null) return new Result(true, null);
        book.setId(null);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.eq(book.getName()!=null, Book::getName, book.getName());
        return new Result(bookService.update(book, lqw));
    }

    @DeleteMapping("{name}")
    public Result remove(@PathVariable String name){
        if(name == null) return new Result(true, null);
        return new Result(bookService.remove(new LambdaQueryWrapper<Book>().eq(Book::getName, name)));
    }

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }
}
