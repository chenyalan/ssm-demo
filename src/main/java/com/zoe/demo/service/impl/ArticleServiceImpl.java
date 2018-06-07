package com.zoe.demo.service.impl;

import com.zoe.demo.dao.ArticleDao;
import com.zoe.demo.entity.Article;
import com.zoe.demo.entity.ArticleDO;
import com.zoe.demo.mapper.ArticleMapper;
import com.zoe.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 陈亚兰 on 2018/3/5.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
//
//    @Autowired
//    private ArticleMapper articleMapper;//mybatis

    @Override
    public ArticleDO add(ArticleDO articleDO) {
        return articleDao.save(articleDO);
    }

    @Override
    public Page getMyArticle(Pageable pageable) {
        return articleDao.getMyArticle(pageable);
    }

    @Override
    public Long delete(Long id) {
        ArticleDO articleDO;
        try {
            articleDO=articleDao.findOne(id);
        }catch (Exception e){
            return -id;
        }
        articleDO.setDeleted(true);
        articleDao.save(articleDO);
        return id;
    }

    @Override
    public Long deleteSelected(Long[] ids) {
        ArticleDO articleDO;
        for(Long id:ids){
            try{
                articleDO=articleDao.findOne(id);
                articleDO.setDeleted(true);
                articleDao.save(articleDO);
            }catch (Exception e){
                return -id;
            }
        }
        return 1L;
    }


    //mybatis，测试而已
    @Override
    public List<Article> selectAll() {
//        return articleMapper.selectAll();
        return null;
    }

    @Override
    public ArticleDO findByAddress(String address) {
        return articleDao.findByAddress(address);
    }
}
