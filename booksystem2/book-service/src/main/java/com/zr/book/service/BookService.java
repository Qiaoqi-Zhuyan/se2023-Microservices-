package com.zr.book.service;

import com.zr.book.service.bo.Book;

public interface BookService {

    /**
     * 更新书籍的存量
     * @param BookId
     * @param quantity
     */
    int updateBookInventory(Long BookId, Long quantity);

    /**
     * 查询书记信息
     * @param BookId
     */
    Book selectBook(Long BookId);

}
