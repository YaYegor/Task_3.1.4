package com.yayegor.web.controller;

import com.yayegor.web.model.User;
import com.yayegor.web.service.RoleService;
import com.yayegor.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("admin", userService.getUserByName(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", new User());
        return "index";
    }


    @PostMapping("/new")
    public String addUser(User user, @RequestParam("listRoles") long[] role_id) {
        userService.addUser(user, role_id);
        return "redirect:/admin";
    }


    @PatchMapping(value = "/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam ("listRoles") long[] roleId) {
        userService.updateUser(user, roleId);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
