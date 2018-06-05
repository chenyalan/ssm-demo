package com.zoe.demo.service.impl;

import com.zoe.demo.dao.BookDao;
import com.zoe.demo.entity.BookEntity;
import com.zoe.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;


/**
 * Created by 陈亚兰 on 2018/2/24.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Cacheable(value="redis",key="#book.bookName",condition="#book.bookName=='哈利'")
    @Override
    public BookEntity add(BookEntity book) {
        System.out.println("添加"+book.getBookName());
        return bookDao.save(book);
    }

    @CachePut(value="redis",key="#bookEntity.id",condition="#result.id<10")
    @Override
    public BookEntity update(BookEntity bookEntity) {
        System.out.println("更新"+bookEntity.getBookName());
        return bookDao.save(bookEntity);
    }

    @CacheEvict(value="redis",key="#id")
    @Override
    public void delete(Long id) {
        System.out.println("删除"+id);
        bookDao.delete(id);
    }

    @Override
    @Cacheable(value = "redis",key="#id")
    public BookEntity getById(Long id){
        System.out.println(id+"并没有在缓存中");
       return bookDao.findOne(id);
    }
}
