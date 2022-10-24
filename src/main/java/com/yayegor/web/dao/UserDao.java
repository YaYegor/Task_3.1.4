package com.yayegor.web.dao;



import com.yayegor.web.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User show(Long id);
    void save(User user);
    void update(Long id, User user);
    void delete(Long id);
}
