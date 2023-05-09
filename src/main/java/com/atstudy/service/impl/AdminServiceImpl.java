package com.atstudy.service.impl;

import com.atstudy.entity.Admin;
import com.atstudy.entity.Role;
import com.atstudy.entity.bo.AdminSearchBo;
import com.atstudy.entity.bo.PageBo;
import com.atstudy.mapper.AdminMapper;
import com.atstudy.mapper.RoleMapper;
import com.atstudy.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录验证 业务逻辑实现类
 */
@Service
public class AdminServiceImpl implements AdminService {


    @Resource
    private AdminMapper adminMapper;



    // 根据用户名获取到 用户实体模型对象(带有角色列表)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminMapper.getAdminByName(username);

        if(admin == null){
            // 如果用户不存在，则抛出异常
            throw new UsernameNotFoundException("账户名获取密码错误，请重新登录");
        }

        return admin;
    }

    @Override
    public List<Admin> listBySearchBo(AdminSearchBo adminSearchBo, PageBo pageBo) {
        // 查询到符合筛选条件的总记录数
        Long count = adminMapper.getCount(adminSearchBo);
        // 给分页模型对象·赋值
        // 给分页模型的总记录数赋值，给总记录数赋值的时候也会给总页数赋值
        pageBo.setResultCount(count);

        // 查询满足条件的员工列表
        List<Admin> admins = adminMapper.listByAdminSearchBo(adminSearchBo,pageBo);
        return admins;
    }
}
