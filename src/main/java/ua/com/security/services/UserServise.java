package ua.com.security.services;




import ua.com.security.entity.User;

import java.util.List;

public interface UserServise {

    void save(User user);

    User findOne(int id);

    List<User> findAll();

    void delete(User user);

    void delete(int id);

    User findByUserName( String name);



}
