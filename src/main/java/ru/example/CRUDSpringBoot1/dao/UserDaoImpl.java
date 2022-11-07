package ru.example.CRUDSpringBoot1.dao;

import org.springframework.stereotype.Repository;
import ru.example.CRUDSpringBoot1.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u ", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.contains(showUser(id)) ? showUser(id) : entityManager.merge(showUser(id)));
    }

    @Override
    public void updateUser(int id, User user) {
        User userToBeUpdate = showUser(id);
        userToBeUpdate.setFirstName(user.getFirstName());
        userToBeUpdate.setLastName(user.getLastName());
        userToBeUpdate.setAge(user.getAge());
        entityManager.merge(userToBeUpdate);
    }

    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }

}
