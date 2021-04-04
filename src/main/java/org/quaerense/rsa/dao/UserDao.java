package org.quaerense.rsa.dao;

import org.quaerense.rsa.domain.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    void update(User user);

    void delete(User user);
}
