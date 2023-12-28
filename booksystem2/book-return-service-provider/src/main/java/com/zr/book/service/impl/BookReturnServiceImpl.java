package com.zr.book.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zr.book.service.BookReturnService;

import com.zr.book.mapper.BookReturnMapper;
import com.zr.book.bo.Book;
import org.springframework.beans.factory.annotation.Autowired;

@Service(interfaceClass = BookReturnService.class)
public class BookReturnServiceImpl implements BookReturnService {

    @Autowired
    private BookReturnMapper bookMapper;

    @Override
    public int returnBook(int bookId, int quantity) {
        Book book = bookMapper.selectBook(bookId);
        if (book == null) {
            return 0;
        }else{
            bookMapper.updateInventory(bookId, -1 * quantity);
            return 1;
        }
    }
}
