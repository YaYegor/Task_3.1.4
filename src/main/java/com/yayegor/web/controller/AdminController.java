package com.yayegor.web.controller;

import com.yayegor.web.model.Role;
import com.yayegor.web.model.User;
import com.yayegor.web.service.RoleService;
import com.yayegor.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @PostMapping("/admin")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/admin/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.getUserById(id);
        userService.updateUser(user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }


    @GetMapping("/header")
    public ResponseEntity<User> getAuthentication(Principal principal) {
        User user = userService.getUserByName(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
