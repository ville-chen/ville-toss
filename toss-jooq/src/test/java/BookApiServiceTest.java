import com.dto.BookDto;
import com.service.BookApiService;
import com.util.JDBCUtil;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ville on 2017/3/25.
 */
public class BookApiServiceTest {

    @Test
    public void createTest() throws SQLException {
        BookApiService bookService = new BookApiService();
        BookDto book = new BookDto();
        book.setId(transferDate(new Date()));
        book.setCreateDate(new Timestamp(System.currentTimeMillis()));
        book.setName("九阳神功");
        book.setPrice(new BigDecimal(99));
        //开启事务
        JDBCUtil.beginTransaction();
        book = bookService.create(book);
        Assert.assertNotNull(book);
        //提交
        JDBCUtil.commitTransaction();
    }

    @Test
    public void queryTest() {
        BookApiService bookService = new BookApiService();
        List<BookDto> bookList = bookService.query();
        bookList.forEach(System.out::println);
    }

    @Test
    public void queryOneByTest() {
        BookApiService bookService = new BookApiService();
        BookDto book = bookService.queryOneById("20171122030043");
        System.out.println(book);
    }

    @Test
    public void modifyByIdTest() throws SQLException {
        BookDto book = new BookDto();
        book.setId("20171122030043");
        book.setCreateDate(new Timestamp(System.currentTimeMillis()));
        book.setName("Three Days to See");
        book.setPrice(new BigDecimal(35));

        BookApiService bookService = new BookApiService();
        //开启事务
        JDBCUtil.beginTransaction();
        if (bookService.modifyById(book) <= 0)
            throw new AssertionError();
        JDBCUtil.commitTransaction();
    }

    @Test
    public void deleteByIdTest() throws SQLException {
        BookApiService bookService = new BookApiService();
        //开启事务
        JDBCUtil.beginTransaction();
        if (bookService.deleteById("20171122030043") <= 0) {
            throw new AssertionError();
        }
    }

    private static String transferDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        return dateFormat.format(date);
    }
}
