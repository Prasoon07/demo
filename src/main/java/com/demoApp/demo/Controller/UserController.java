package com.demoApp.demo.Controller;

import com.demoApp.demo.Model.User;
import com.demoApp.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("demoApp")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    //For test purpose only
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("users", userService.findAll());
        return "test";
    }

    @GetMapping("userList")
    public String getUser(Model model){
        model.addAttribute("users", userService.findAll());
        return "UserPage/user-index";
    }

    @GetMapping("create-user")
    public String createUser(@ModelAttribute User user) {
        return "UserPage/user-create";
    }

    @PostMapping("user_store")
    public String addNewUser(@ModelAttribute User user) {
        userService.addNewUser(user);
        return "redirect:/demoApp/userList";
    }

    @GetMapping("edit-user/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "UserPage/user-edit";
    }

    @PostMapping("user_update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/demoApp/userList";
    }

    @GetMapping("delete-user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/demoApp/userList";
    }

}
