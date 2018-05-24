package com.zoe.demo.dao;

import com.zoe.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 陈亚兰 on 2018/2/24.
 */
public interface BookDao extends JpaRepository<BookEntity,Long> {
}
