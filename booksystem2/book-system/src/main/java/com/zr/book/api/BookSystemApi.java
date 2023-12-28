package com.zr.book.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zr.book.service.BookBorrowService;
import com.zr.book.service.BookReturnService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
@RestController
public class BookSystemApi {
    @Reference
    private BookReturnService bookReturnService;

    @Reference
    private BookBorrowService bookBorrowService;

    @RequestMapping("/bookReturn")
    public void BookReturn(Long bookId, Long quantity){
        int bookid_ = 1;
        int quantity_ = 1;
        int message = bookReturnService.returnBook(bookid_, quantity_);
        if (message == 0){
            System.out.println("No such book");
        }else{
            System.out.println("SUCCESS, return " + bookid_ + " books" + " Book id: " + bookid_);
        }
    }

    @RequestMapping("/bookBorrow")
    public void BookBorrow(Long bookId, Long quantity){

        int bookid_ = 1;
        int quantity_ = 1;
        int message = bookBorrowService.borrowBook(bookid_, quantity_);
        if (message == -1) {
            System.out.println("No Such book");
        } else if (message == 0) {
            System.out.println("out of stock");
        } else if (message == 1) {
            System.out.println("SUCCESS, borrow" + quantity_ + " books" + " Book id: " + bookid_);
        }
    }
}
