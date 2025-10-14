package service;

import dao.BookDao;
import model.BookModel;

public class BookService {
    private final BookDao bookDao = new BookDao();

    public void registerBook(String nameBook, int stock, String isbn) {
        BookModel bookModel = new BookModel(nameBook, stock, isbn);
        bookDao.create(bookModel);
    }
}
