package com.zr.book.mapper;

import com.zr.book.service.bo.Book;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    /**
     *  查找书目
     * @param BookID
     * @return
     */
    Book selectBook(Long BookID);


    /**
     * 按照书的ID更新表
     *
     * @param bookID
     * @param quantity
     */

    void updateInventory(@Param("bookID") Long bookID, @Param("quantity") Long quantity);


}
