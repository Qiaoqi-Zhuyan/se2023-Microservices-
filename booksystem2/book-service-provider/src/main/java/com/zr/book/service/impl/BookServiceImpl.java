package com.zr.book.service.impl;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zr.book.mapper.BookMapper;
import com.zr.book.service.BookService;
import com.zr.book.service.bo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import java.io.File;
import java.util.logging.Logger;


@Service(interfaceClass = BookService.class)
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int updateBookInventory(Long bookId, Long quantity) {
        Book selectBook = bookMapper.selectBook(bookId);

        if (selectBook == null){
             return 0;
        } else{
              bookMapper.updateInventory(bookId, quantity);
              return 1;
        }
    }
    @Override
    public Book selectBook(Long BookId) {
        return bookMapper.selectBook(BookId);
    }
}
