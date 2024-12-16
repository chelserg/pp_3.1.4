package ru.chelserg.btstrap.service;

import ru.chelserg.btstrap.models.User;

import java.util.List;

public interface UserService {



    User saveUser(User user);

    void deleteById(Long id);

    List<User> findAll();

    User findById(Long id);
    void updateUser(Long id, User user);
}
