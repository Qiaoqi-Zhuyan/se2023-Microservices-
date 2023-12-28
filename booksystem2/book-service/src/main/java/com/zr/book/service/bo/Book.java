package com.zr.book.service.bo;

public class Book {
    private Long bookId;
    private String title;
    private String author;
    private Long isbn;
    private Long stock;
    private Long borrowedQuantity;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getBorrowedQuantity() {
        return borrowedQuantity;
    }

    public void setBorrowedQuantity(Long borrowedQuantity) {
        this.borrowedQuantity = borrowedQuantity;
    }
}
