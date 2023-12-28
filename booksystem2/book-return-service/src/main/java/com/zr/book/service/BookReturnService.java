package com.zr.book.service;

public interface BookReturnService {


    /**
     * 归还书籍
     * @param bookId
     * @param quantity
     * @return
     */
    public int returnBook(int bookId, int quantity);


}
