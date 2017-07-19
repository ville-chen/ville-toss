package com.service;

import com.pojo.Role;

import java.util.List;

/**
 * Created by ville on 2017/7/18.
 */
public interface RoleService {

    int saveRole(Role role);

    int removeRole(Integer id);

    int updateRole(Role role);

    Role getRole(Integer id);

    List<Role> listRoles(int pageNo, int pageSize);
}
