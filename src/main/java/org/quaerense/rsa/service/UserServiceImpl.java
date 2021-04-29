package org.quaerense.rsa.service;

import org.quaerense.rsa.dao.RoleDao;
import org.quaerense.rsa.dao.UserDao;
import org.quaerense.rsa.domain.Role;
import org.quaerense.rsa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userDao.create(user);
    }

    @Override
    @Transactional
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public Role findRoleById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    @Transactional
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
