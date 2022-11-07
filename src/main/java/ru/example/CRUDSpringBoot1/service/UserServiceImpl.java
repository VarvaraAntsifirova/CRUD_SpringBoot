package ru.example.CRUDSpringBoot1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.example.CRUDSpringBoot1.dao.UserDaoImpl;
import ru.example.CRUDSpringBoot1.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoImpl.getAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDaoImpl.createUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDaoImpl.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userDaoImpl.updateUser(id, user);
    }

    @Override
    public User showUser(int id) {
        return userDaoImpl.showUser(id);
    }
}
