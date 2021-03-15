package web.service;


import web.model.User;

import java.util.List;

public interface UserService {

    public void add(User user);

    public List<User> listUsers();

    public void delete(User user);

    public void deleteById(Long id);

    public User update(User user);

    public User getUserById(Long id);
}
