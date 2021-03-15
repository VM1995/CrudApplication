package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery(" from User ", User.class).getResultList();
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.createQuery(" from User id where id =:id")
                .setParameter("id", user.getId())
                .getSingleResult());

    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.createQuery("from User where id =:id")
                .setParameter("id", id)
                .getSingleResult());
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        return (User) entityManager.createQuery("from User where id =:longID")
                .setParameter("longID", id)
                .getSingleResult();
    }
}
