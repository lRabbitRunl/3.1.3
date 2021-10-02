package com.javaMentor.CRUD.UserService;


import com.javaMentor.CRUD.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
    List<User> getAllUsers();
    User findByLogin(String login);
    void returnPas(User user);
    void setPas(User user);
}
