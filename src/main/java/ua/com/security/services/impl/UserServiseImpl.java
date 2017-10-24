package ua.com.security.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.security.dao.UserDAO;
import ua.com.security.entity.User;
import ua.com.security.services.UserServise;

import java.util.List;

@Service
@Transactional
public class UserServiseImpl implements UserServise,UserDetailsService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public User findOne(int id) {

        return userDAO.findOne(id);
    }

    public List<User> findAll() {

        return userDAO.findAll();
    }

    public void delete(User user) {
        userDAO.delete(user);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    public void save(User user) {
        String encodePass=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePass);
        userDAO.save(user);
    }



    @Override
    public User findByUserName(String name) {
        return userDAO.findByUserName(name);
    }



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return findByUserName(name);
    }


}
