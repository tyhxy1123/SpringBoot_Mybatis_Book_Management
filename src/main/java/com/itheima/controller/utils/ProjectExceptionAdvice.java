package com.itheima.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(IOException.class)
    public Result doException(Exception ex){
        System.err.println("Ausnahme aufgetaucht!");
        System.err.println("Log ist gespeichert, Ops wurde informiert");
        ex.printStackTrace();
        return new Result( "Vorgang nicht möglich, versuchen Sie später biite noch einmal");
    }
}
