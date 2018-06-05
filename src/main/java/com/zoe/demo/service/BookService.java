package com.zoe.demo.service;


import com.zoe.demo.entity.BookEntity;

/**
 * Created by 陈亚兰 on 2018/2/24.
 */
public interface BookService {
    BookEntity add(BookEntity book);
    BookEntity update(BookEntity bookEntity);
    void delete(Long id);
    BookEntity getById(Long id);
}
