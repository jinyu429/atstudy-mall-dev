package com.atstudy.controller;

import com.atstudy.entity.Admin;
import com.atstudy.entity.bo.AdminSearchBo;
import com.atstudy.entity.bo.PageBo;
import com.atstudy.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private RoleService roleService;


    @RequestMapping("/admin")
    public String admin(AdminSearchBo adminSearchBo, PageBo pageBo, Model model){
        // 获取到了符合条件的员工列表，并且给分页模型赋值了
        List<Admin> admins = adminService.listBySearchBo(adminSearchBo, pageBo);

        // 将员工列表和分页模型全部放入请求域中
        model.addAttribute("adminList",admins);
        model.addAttribute("pageBo",pageBo);

        // 将查询条件放到请求域中，做·持久化
        model.addAttribute("searchBo",adminSearchBo);
        // 将所有的角色放到请求域中
        model.addAttribute("roleList",roleService.list());
        return "admin/admin";
    }
}
