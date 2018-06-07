package com.zoe.demo.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by 陈亚兰 on 2018/5/24.
 */
@Data
public class PermissionDTO {
    @NotNull
    private String permissionEN;
    @NotNull
    private String permissionCN;
}
