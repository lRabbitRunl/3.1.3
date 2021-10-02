package com.javaMentor.CRUD.UserService;

import com.javaMentor.CRUD.model.Role;
import com.javaMentor.CRUD.model.User;
import com.javaMentor.CRUD.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;


    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        if (roleRepository.findAll().isEmpty()) {
            roleRepository.save(new Role("USER"));
            roleRepository.save(new Role("ADMIN"));
        }
    }



    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }



    public void setRoles(User user){
        Set<Role> temp = new HashSet<>();
        user.getRoles().forEach(role -> temp.add(roleRepository.findById(role.getId()).get()));
        user.setRoles(temp);
    }

    public void setdefaultRoleIfNotSelected(User user){
        if (user.getRoles().isEmpty()) {
            user.setRole(new Role(1));
        }
    }
}



