package org.quaerense.rsa.dao;

import org.quaerense.rsa.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    Role findById(Long id);
}
