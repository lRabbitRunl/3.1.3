package com.javaMentor.CRUD.UserService;

import com.javaMentor.CRUD.model.Role;
import com.javaMentor.CRUD.model.User;

import java.util.List;


public interface RoleService {


    List<Role> getAllRoles();

    void setRoles(User user);

    void setdefaultRoleIfNotSelected(User user);
}
