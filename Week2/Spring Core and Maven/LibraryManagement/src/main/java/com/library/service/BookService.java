package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected by Spring!");
    }

    public void getBook(int id) {
        System.out.println("BookService: Requesting book with ID " + id);
        String book = bookRepository.findBookById(id);
        System.out.println("BookService: Found - " + book);
    }

    public void getAllBooks() {
        System.out.println("BookService: Requesting all books...");
        bookRepository.findAllBooks();
    }

    public void addBook(String bookName) {
        System.out.println("BookService: Adding new book - " + bookName);
        bookRepository.saveBook(bookName);
    }
}