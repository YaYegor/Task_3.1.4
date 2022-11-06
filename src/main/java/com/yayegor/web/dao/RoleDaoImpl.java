package com.yayegor.web.dao;

import com.yayegor.web.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Set<Role> getRoles() {
        return entityManager.createQuery("select r FROM Role r", Role.class).getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
