package com.yayegor.web.dao;

import com.yayegor.web.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select r FROM Role r", Role.class).getResultList();

    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
