package org.quaerense.rsa.converter;

import org.quaerense.rsa.domain.Role;
import org.quaerense.rsa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleByIdConverter implements Converter<String, Role> {
    @Autowired
    private UserService userService;

    @Override
    public Role convert(String id) {
        return userService.findRoleById(Long.valueOf(id));
    }
}
