package com.atstudy.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer menuId;
    private String menuName;
    private String menuUrl;
    private Integer pid;
}
