package com.library.repository;

public class BookRepository {
	public String findBookById(int id) {
        System.out.println("BookRepository: Finding book with ID " + id);
        return "Clean Code by Robert C. Martin";
    }

    public void findAllBooks() {
        System.out.println("BookRepository: Fetching all books from database...");
        System.out.println("1. Clean Code - Robert C. Martin");
        System.out.println("2. The Pragmatic Programmer - Andrew Hunt");
        System.out.println("3. Design Patterns - Gang of Four");
    }

    public void saveBook(String bookName) {
        System.out.println("BookRepository: Saving book '" + bookName + "' to database.");
    }
}
