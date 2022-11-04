package com.yayegor.web.service;

import com.yayegor.web.dao.RoleDao;
import com.yayegor.web.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Set<Role> findRolesByName(String roleName) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getRoles()) {
            if (roleName.contains(role.getRoleName())) {
                roles.add(role);
            }
        }
        return roles;
    }
}
