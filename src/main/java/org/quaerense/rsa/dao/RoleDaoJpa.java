package org.quaerense.rsa.dao;

import org.quaerense.rsa.domain.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoJpa implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    public Role findById(Long id) {
        return entityManager.find(Role.class, id);
    }
}
