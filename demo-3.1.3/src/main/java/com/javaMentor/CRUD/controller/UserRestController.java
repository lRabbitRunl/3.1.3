package com.javaMentor.CRUD.controller;

import com.javaMentor.CRUD.UserService.RoleService;
import com.javaMentor.CRUD.UserService.UserService;
import com.javaMentor.CRUD.model.User;
import org.springframework.web.bind.annotation.*;
import com.javaMentor.CRUD.model.Role;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/rest/")
public class UserRestController {


    private final UserService userService;
    private final RoleService roleService;

    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }



    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.setPas(user);
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public User getUser(Principal user) {
        return userService.findByLogin(user.getName());
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();

    }

    @PutMapping("/users")
    public void editUser(@RequestBody User user) {
        userService.setPas(user);
        userService.returnPas(user);
        userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
