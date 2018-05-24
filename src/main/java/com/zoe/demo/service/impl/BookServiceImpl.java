package com.zoe.demo.service.impl;

import com.zoe.demo.dao.BookDao;
import com.zoe.demo.entity.BookEntity;
import com.zoe.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 陈亚兰 on 2018/2/24.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public BookEntity add(BookEntity book) {
        return bookDao.save(book);
    }
}
