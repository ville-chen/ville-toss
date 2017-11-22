/*
 * This file is generated by jOOQ.
*/
package com.repository;


import com.repository.tables.TbBook;
import com.repository.tables.records.TbBookRecord;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships between tables of the <code>bookdb</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<TbBookRecord> KEY_TB_BOOK_PRIMARY = UniqueKeys0.KEY_TB_BOOK_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<TbBookRecord> KEY_TB_BOOK_PRIMARY = createUniqueKey(TbBook.TB_BOOK, "KEY_tb_book_PRIMARY", TbBook.TB_BOOK.ID);
    }
}
