package com.zoe.demo.entity;
import com.zoe.demo.meiju.Sex;
import com.zoe.demo.meiju.State;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 陈亚兰 on 2018/1/31.
 */
@Entity
@Table(name="sys_user")
@Where(clause = "deleted=0")
@Getter
@Setter
public class SysUserDO extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7275850882186338768L;
    @Column(columnDefinition = "varchar(40) comment '帐户名，唯一'")
    private String account;
    @Column(columnDefinition = "varchar(40) comment '用户名'")
    private String username;
    @Column(columnDefinition = "varchar(40) comment '密码'")
    private String password;
    @Column(columnDefinition = "varchar(40) comment '电话'")
    private String telephone;
    @Column(columnDefinition = "varchar(40) comment '邮箱'")
    private String email;
    @Column(columnDefinition = "varchar(40) comment '地址'")
    private String address;
    @Column(columnDefinition = "varchar(40) comment '班级'")
    private String className;
    @Column(columnDefinition = "varchar(40) comment '年级'")
    private String grade;
    @Column(columnDefinition = "int(2) comment '性别'")
    private Sex sex;
    @OneToOne
    private SysRoleDO role;
    @Lob
    private String remark;
    private String photoAddress;

    private String salt;

    private State userState;
    public SysUserDO(){}
    //用户注册时所调构造函数，状态初始正在注册
    public SysUserDO(String account,String username,String password,String email,String salt){
        this.account=account;
        this.username=username;
        this.password=password;
        this.email=email;
        this.salt=salt;
        this.setUserState(State.Registering);
        this.setDeleted(false);
    }
    //添加用户所调构造函数，可以直接使用
    public SysUserDO(String account,String username,String password,String telephone,String email,String address,String className,String grade,Sex sex,String remark,String  salt){
        this.account=account;
        this.username=username;
        this.password=password;
        this.telephone=telephone;
        this.email=email;
        this.address=address;
        this.className=className;
        this.grade=grade;
        this.sex=sex;
        this.remark=remark;
        this.salt=salt;
        this.setDeleted(false);
        this.setUserState(State.Using);
    }

}
