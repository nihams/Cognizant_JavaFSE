package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {

    public static void main(String[] args) {

    	System.out.println("=== Starting Spring Application Context ===\n");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("\n=== Testing BookService Operations ===\n");

        bookService.getAllBooks();
        System.out.println();

        bookService.getBook(1);
        System.out.println();

        bookService.addBook("Effective Java by Joshua Bloch");

        System.out.println("\n=== Closing Spring Application Context ===");
        ((ClassPathXmlApplicationContext) context).close();
    }
}