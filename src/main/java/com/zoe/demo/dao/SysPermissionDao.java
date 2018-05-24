package com.zoe.demo.dao;

import com.zoe.demo.entity.SysPermissionDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by 陈亚兰 on 2018/2/1.
 */
public interface SysPermissionDao extends JpaRepository<SysPermissionDO,Long> {
    List<SysPermissionDO> findAll();
    Page<SysPermissionDO> findAll(Pageable pageable);
    @Query(value = "select s from SysPermissionDO s where  s.id in ?1")
    Set<SysPermissionDO>  findSet(Long[] ids);
    SysPermissionDO findById(Long id);
//    @Query(value = "select s from SysPermissionDO s where s.permissionCN=?1 and s.permissionEN=?2")
    SysPermissionDO findByPermissionCNOrPermissionEN(String permissionCN,String permissionEN);
 }
