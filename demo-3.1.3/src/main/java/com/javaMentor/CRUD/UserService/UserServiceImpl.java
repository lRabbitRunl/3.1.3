package com.javaMentor.CRUD.UserService;


import com.javaMentor.CRUD.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.javaMentor.CRUD.model.User;

import java.util.List;

@AllArgsConstructor
@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }



    public void setPas(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
    }

    public void returnPas(User user){
        String pass = getUser(user.getId()).getPassword();
        if (user.getPassword().isEmpty()) {
            user.setPassword(pass);
        }
    }


}
