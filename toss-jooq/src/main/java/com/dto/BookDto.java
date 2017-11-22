package com.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ville on 2017/3/25.
 */
@Data
public class BookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Date createDate;

    private String name;

    private BigDecimal price;

    public BookDto() {
    }

    public BookDto(String id, Date createDate, String name, BigDecimal price) {
        this.id = id;
        this.createDate = createDate;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书本信息:{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                '}';
    }
}
