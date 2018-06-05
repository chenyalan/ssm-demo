package com.zoe.demo.entity;

import javax.persistence.*;

/**
 * Created by 陈亚兰 on 2018/2/24.
 */
@Table(name = "tbl_book")
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
