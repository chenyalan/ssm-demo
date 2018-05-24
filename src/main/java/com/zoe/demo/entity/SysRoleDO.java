package com.zoe.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by 陈亚兰 on 2018/1/31.
 */
@Entity
@Table(name="sys_role")
@Where(clause = "deleted=0")
@Getter
@Setter
public class SysRoleDO extends BaseEntity  implements Serializable {
    private static final long serialVersionUID = 5877100122277246969L;
    @Column(columnDefinition = "varchar(40) comment '角色名'")
    private String roleName;
    @Column(columnDefinition = "varchar(40) comment '角色类型'")
    private String roleType;
//    @OneToMany
//    private Set<SysUserDO> users;
    @ManyToMany
    @JoinTable(name="sys_role_permission",joinColumns = {@JoinColumn(name = "role_id")},inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<SysPermissionDO> permissions;
    public SysRoleDO(){}
    public SysRoleDO(String roleName,String roleType){
        this.roleName=roleName;
        this.roleType=roleType;
    }

}
