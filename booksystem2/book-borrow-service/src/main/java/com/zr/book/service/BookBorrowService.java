package com.zr.book.service;

import com.zr.book.bo.Book;

public interface BookBorrowService {

    /**
     * 查看书库存和信息
     * @param BookId 书ID
     * @return
     */
    public Book checkBook(int BookId);

    /**
     * 借书服务
     * @param BookId
     * @param quantity 借书数量
     * @return
     */
    public int borrowBook(int BookId, int quantity);

}
