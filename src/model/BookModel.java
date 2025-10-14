package model;

public class BookModel {
    private int idBook;
    private String nameBook;
    private int stock;
    private String isbn;

    // Constructors


    public BookModel(String nameBook, int stock, String isbn) {
        this.nameBook = nameBook;
        this.stock = stock;
        this.isbn = isbn;
    }

    public BookModel(int idBook, String nameBook, int stock, String isbn) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.stock = stock;
        this.isbn = isbn;
    }

    // Getters & Setters
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getInformation() {
        return "ID Book: #" + getIdBook() + " - Book Name: " + getNameBook() + " - Stock: " + getStock() + " - ISBN: " + getIsbn();
    }
}
