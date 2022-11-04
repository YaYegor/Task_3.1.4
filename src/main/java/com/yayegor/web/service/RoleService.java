package com.yayegor.web.service;

import com.yayegor.web.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getRoles();
    Set<Role> findRolesByName(String roleName);
}
