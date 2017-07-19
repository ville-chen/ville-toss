package com.controller;

import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * Created by ville on 2017/7/18.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @RequestMapping("/getRole")
    @ResponseBody
    public Role getRole(Integer id) {
        Role role = null;
        if (Objects.nonNull(id)) {
            role = roleService.getRole(id);
        }
        return role;
    }

}
