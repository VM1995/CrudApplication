package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    @Qualifier("userDAOImp")
    private UserDAO userDAO;

    @Autowired
    public UserDAO getUserDao() {
        return userDAO;
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

}
