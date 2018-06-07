package com.zoe.demo.service;

import com.zoe.demo.entity.Article;
import com.zoe.demo.entity.ArticleDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by 陈亚兰 on 2018/3/5.
 */
public interface ArticleService {
    ArticleDO add(ArticleDO articleDO);
    Page getMyArticle(Pageable pageable);
    Long delete(Long id);
    Long deleteSelected(Long[] ids);

    //mybatis
    List<Article>  selectAll();

    ArticleDO findByAddress(String address);
}
