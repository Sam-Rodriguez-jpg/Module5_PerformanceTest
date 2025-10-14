package controller;

import service.BookService;

public class BookController {
    private final BookService bookService = new BookService();

    public void addBook(String nameBook, int stock, String isbn) {
        bookService.registerBook(nameBook, stock, isbn);
    }
}
