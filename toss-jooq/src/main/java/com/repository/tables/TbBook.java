/*
 * This file is generated by jOOQ.
*/
package com.repository.tables;


import com.repository.Bookdb;
import com.repository.Keys;
import com.repository.tables.records.TbBookRecord;
import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbBook extends TableImpl<TbBookRecord> {

    private static final long serialVersionUID = 1767096638;

    /**
     * The reference instance of <code>bookdb.tb_book</code>
     */
    public static final TbBook TB_BOOK = new TbBook();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TbBookRecord> getRecordType() {
        return TbBookRecord.class;
    }

    /**
     * The column <code>bookdb.tb_book.id</code>.
     */
    public final TableField<TbBookRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR.length(14).nullable(false), this, "");

    /**
     * The column <code>bookdb.tb_book.create_date</code>.
     */
    public final TableField<TbBookRecord, Timestamp> CREATE_DATE = createField("create_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("2017-01-01 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>bookdb.tb_book.name</code>.
     */
    public final TableField<TbBookRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>bookdb.tb_book.price</code>.
     */
    public final TableField<TbBookRecord, BigDecimal> PRICE = createField("price", org.jooq.impl.SQLDataType.DECIMAL.precision(10, 2).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.00", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * Create a <code>bookdb.tb_book</code> table reference
     */
    public TbBook() {
        this("tb_book", null);
    }

    /**
     * Create an aliased <code>bookdb.tb_book</code> table reference
     */
    public TbBook(String alias) {
        this(alias, TB_BOOK);
    }

    private TbBook(String alias, Table<TbBookRecord> aliased) {
        this(alias, aliased, null);
    }

    private TbBook(String alias, Table<TbBookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Bookdb.BOOKDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TbBookRecord> getPrimaryKey() {
        return Keys.KEY_TB_BOOK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TbBookRecord>> getKeys() {
        return Arrays.<UniqueKey<TbBookRecord>>asList(Keys.KEY_TB_BOOK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBook as(String alias) {
        return new TbBook(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TbBook rename(String name) {
        return new TbBook(name, null);
    }
}
