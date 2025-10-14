package view;

import controller.BookController;

import javax.swing.*;

import static util.ValidEntriesUtil.*;

public class BookView {
    private final BookController bookController = new BookController();

    public void createBook() {
        String nameBook = validString("Enter book name:");
        int stock = validOnlyPositiveInts("Enter book stock");
        String isbn = validString("Enter ISBN code:");

        bookController.addBook(nameBook, stock, isbn);
        JOptionPane.showMessageDialog(null, "Book registered successfully!");
    }
}
