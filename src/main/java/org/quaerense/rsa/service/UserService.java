package org.quaerense.rsa.service;

import org.quaerense.rsa.domain.Role;
import org.quaerense.rsa.domain.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> findAllUsers();

    User findUserById(Long id);

    User findUserByUsername(String username);

    Role findRoleById(Long id);

    List<Role> findAllRoles();

    void updateUser(User user);

    void deleteUser(User user);
}
