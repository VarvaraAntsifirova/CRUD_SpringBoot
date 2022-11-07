package ru.example.CRUDSpringBoot1.service;

import ru.example.CRUDSpringBoot1.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(int id);

    void updateUser(int id, User user);

    User showUser(int id);
}
