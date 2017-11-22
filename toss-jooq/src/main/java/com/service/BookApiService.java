package com.service;

import com.api.BookApi;
import com.dto.BookDto;
import com.repository.Tables;
import com.repository.tables.TbBook;
import com.util.JDBCUtil;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ville on 2017/3/25.
 */
public class BookApiService implements BookApi {

    private Connection conn;

    private DSLContext context;

    @Override
    public BookDto create(BookDto book) {
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败，请检测服务状态以及配置正确性！");
        }
        context = DSL.using(conn, SQLDialect.MYSQL);

        int result = context.insertInto(Tables.TB_BOOK).set(TbBook.TB_BOOK.ID, book.getId())
                .set(TbBook.TB_BOOK.NAME, book.getName())
                .set(TbBook.TB_BOOK.PRICE, book.getPrice())
                .set(TbBook.TB_BOOK.CREATE_DATE, (Timestamp) book.getCreateDate())
                .execute();
        context.close();
        if (result > 0) {
            return book;
        }
        return null;
    }

    @Override
    public Integer modifyById(BookDto book) {
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败，请检测服务状态以及配置正确性！");
        }
        context = DSL.using(conn, SQLDialect.MYSQL);

        return context.update(Tables.TB_BOOK).set(TbBook.TB_BOOK.NAME, book.getName())
                .set(TbBook.TB_BOOK.PRICE, book.getPrice())
                .set(TbBook.TB_BOOK.CREATE_DATE, (Timestamp) book.getCreateDate())
                .where(TbBook.TB_BOOK.ID.eq(book.getId())).execute();
    }

    @Override
    public Integer deleteById(String bookId) {
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败，请检测服务状态以及配置正确性！");
        }
        context = DSL.using(conn, SQLDialect.MYSQL);
        return context.deleteFrom(Tables.TB_BOOK).where(TbBook.TB_BOOK.ID.eq(bookId)).execute();
    }

    @Override
    public List<BookDto> query() {
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败，请检测服务状态以及配置正确性！");
        }
        context = DSL.using(conn, SQLDialect.MYSQL);
        return context.selectFrom(Tables.TB_BOOK).fetchInto(BookDto.class);
    }

    @Override
    public BookDto queryOneById(String bookId) {
        try {
            conn = JDBCUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败，请检测服务状态以及配置正确性！");
        }
        context = DSL.using(conn, SQLDialect.MYSQL);
        return context.selectFrom(Tables.TB_BOOK).where(TbBook.TB_BOOK.ID.eq(bookId)).fetchAnyInto(BookDto.class);
    }

}
