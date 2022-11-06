package com.yayegor.web.service;


import com.yayegor.web.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getRoles();
    Set<Role> findRolesByName(String name);
}
