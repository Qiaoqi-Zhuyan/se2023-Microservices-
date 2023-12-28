package com.zr.book.service.impl;

import com.zr.book.mapper.BookBorrowMapper;
import com.zr.book.service.BookBorrowService;
import com.zr.book.bo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;


@Service(interfaceClass=BookBorrowService.class)
public class BookBorrowServiceImpl implements BookBorrowService {

    @Autowired
    private BookBorrowMapper bookMapper;

    private boolean isBookAvailable(Book book, int quantity){
        return book.getStock() < 0 || book.getStock() < quantity;
    }

    @Override
    public Book checkBook(int BookId) {
        return bookMapper.selectBook(BookId);
    }

    @Override
    public int borrowBook(int bookId, int quantity) {

        Book book = bookMapper.selectBook(bookId);

        if(book == null){
            return -1;
        }else {
            if (book.getStock() > 0 && book.getStock() >= quantity) {
                bookMapper.updateInventory(bookId, quantity);
                return 1;
            } else {
                return 0;
            }
        }
    }
}
