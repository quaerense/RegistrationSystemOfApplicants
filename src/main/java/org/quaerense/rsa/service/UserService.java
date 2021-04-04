package org.quaerense.rsa.service;

import org.quaerense.rsa.domain.User;

import java.util.List;

public interface UserService {
    void create(User user);

    List<User> findAll();

    User findById(Long id);

    User findByUsername(String username);

    void update(User user);

    void delete(User user);
}
