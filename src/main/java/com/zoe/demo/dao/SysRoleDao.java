package com.zoe.demo.dao;

import com.zoe.demo.entity.SysRoleDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 陈亚兰 on 2018/2/1.
 */
public interface SysRoleDao extends JpaRepository<SysRoleDO,Long> {
    List<SysRoleDO> findAll();
    Page<SysRoleDO> findAll(Pageable pageable);
    SysRoleDO findByRoleName(String roleName);
    SysRoleDO findById(Long id);
}
