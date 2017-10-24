package ua.com.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.security.entity.User;


public interface UserDAO extends JpaRepository<User,Integer> {
    @Query("from User u where u.username=:xxx")
    User findByUserName(@Param("xxx") String name);

}