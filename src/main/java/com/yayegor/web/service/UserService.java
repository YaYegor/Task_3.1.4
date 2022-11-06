package com.yayegor.web.service;




import com.yayegor.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user, long[] listRoles);
    void deleteUser(Long id);
    void updateUser(User user, long[] roleId);
    User getUserByName(String name);
}
