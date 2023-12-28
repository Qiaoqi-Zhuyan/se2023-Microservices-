package com.zr.book.mapper;

import com.zr.book.bo.Book;
import org.apache.ibatis.annotations.Param;

public interface BookReturnMapper {
    /**
     *  查找书目
     * @param BookID
     * @return
     */
    Book selectBook(int BookID);


    /**
     * 按照书的ID更新表
     *
     * @param bookID
     * @param quantity
     */

    void updateInventory(@Param("bookId") int bookID, @Param("quantity") int quantity);

}
