package com.atstudy.entity.bo;

import lombok.Data;

@Data
public class AdminSearchBo {
    private Integer adminId;            // 员工编号
    private String adminName;           // 员工名称
    private String adminNickname;       // 员工姓名
    private Integer roleId;             // 角色编号
}
