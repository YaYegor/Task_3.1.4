package com.yayegor.web.dao;


import com.yayegor.web.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getRoles();
    Role getRoleById(Long id);
}
