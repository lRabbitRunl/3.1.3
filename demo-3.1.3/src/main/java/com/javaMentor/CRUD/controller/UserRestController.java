package com.javaMentor.CRUD.controller;

import com.javaMentor.CRUD.UserService.RoleService;
import com.javaMentor.CRUD.UserService.UserService;
import com.javaMentor.CRUD.model.User;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());

    }

    @PostMapping("/users")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        roleService.setRoles(user);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(Principal user) {
        return ResponseEntity.ok(userService.findByLogin(user.getName()));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());

    }

    @PutMapping("/users")
    public void editUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
