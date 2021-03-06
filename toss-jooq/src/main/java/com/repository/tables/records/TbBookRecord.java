/*
 * This file is generated by jOOQ.
*/
package com.repository.tables.records;


import com.repository.tables.TbBook;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.sql.Timestamp;


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
public class TbBookRecord extends UpdatableRecordImpl<TbBookRecord> implements Record4<String, Timestamp, String, BigDecimal> {

    private static final long serialVersionUID = -2093195830;

    /**
     * Setter for <code>bookdb.tb_book.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bookdb.tb_book.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bookdb.tb_book.create_date</code>.
     */
    public void setCreateDate(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>bookdb.tb_book.create_date</code>.
     */
    public Timestamp getCreateDate() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>bookdb.tb_book.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bookdb.tb_book.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bookdb.tb_book.price</code>.
     */
    public void setPrice(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>bookdb.tb_book.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Timestamp, String, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, Timestamp, String, BigDecimal> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TbBook.TB_BOOK.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field2() {
        return TbBook.TB_BOOK.CREATE_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TbBook.TB_BOOK.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return TbBook.TB_BOOK.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value2() {
        return getCreateDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value4() {
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBookRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBookRecord value2(Timestamp value) {
        setCreateDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBookRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBookRecord value4(BigDecimal value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TbBookRecord values(String value1, Timestamp value2, String value3, BigDecimal value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbBookRecord
     */
    public TbBookRecord() {
        super(TbBook.TB_BOOK);
    }

    /**
     * Create a detached, initialised TbBookRecord
     */
    public TbBookRecord(String id, Timestamp createDate, String name, BigDecimal price) {
        super(TbBook.TB_BOOK);

        set(0, id);
        set(1, createDate);
        set(2, name);
        set(3, price);
    }
}
