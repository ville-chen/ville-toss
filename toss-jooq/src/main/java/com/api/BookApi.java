package com.api;

import com.dto.BookDto;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ville on 2017/3/25.
 */
public interface BookApi {

    BookDto create(BookDto book) throws SQLException;

    Integer modifyById(BookDto book);

    Integer deleteById(String bookId);

    List<BookDto> query();

    BookDto queryOneById(String bookId);

}
