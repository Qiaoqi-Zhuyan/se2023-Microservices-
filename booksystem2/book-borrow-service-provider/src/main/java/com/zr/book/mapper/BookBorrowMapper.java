package com.zr.book.mapper;
import com.zr.book.bo.Book;
import org.apache.ibatis.annotations.Param;


public interface BookBorrowMapper {
    /**
     *  查找书目
     * @param BookID
     * @return
     */
    Book selectBook(int BookID);


    /**
     * 按照书的ID更新表
     *
     * @param bookId
     * @param quantity
     */

    void updateInventory(@Param("bookId")int bookId, @Param("quantity")int quantity);


}
