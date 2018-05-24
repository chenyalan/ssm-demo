package com.zoe.demo.dao;

import com.zoe.demo.entity.SysRoleDO;
import com.zoe.demo.entity.SysUserDO;
import com.zoe.demo.meiju.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by 陈亚兰 on 2018/2/1.
 */
public interface SysUserDao extends JpaRepository<SysUserDO,Long> {
    @Query(value = "select user from SysUserDO user where account=?1")
    SysUserDO findAccount(String account);
    SysUserDO findByEmail(String email);
    SysUserDO findByAccountAndPassword(String account, String password);
    SysUserDO findById(Long id);
    Set<SysUserDO> findByRole(SysRoleDO sysRoleDO);
    List<SysUserDO> findByUserStateEquals(State state);
    int deleteById(Long id);
}
