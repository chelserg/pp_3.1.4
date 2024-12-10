package ru.chelserg.btstrap.service;

import ru.chelserg.btstrap.models.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();


    User showUserById(Long id);

    User saveUser(User user);

    void deleteUserById(Long id);


    User findUserByUsername(String username);
}
