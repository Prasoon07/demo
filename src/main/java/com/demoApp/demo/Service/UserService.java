package com.demoApp.demo.Service;

import com.demoApp.demo.Model.User;
import com.demoApp.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public String addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Added";
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public String updateUser(Long id, User user) {
        User update_user = userRepository.findById(id).get();

        update_user.setName(user.getName());
        update_user.setEmail(user.getEmail());
        update_user.setPassword(passwordEncoder.encode(user.getPassword()));
        update_user.setPhone(user.getPhone());
        update_user.setAddress(user.getAddress());

        userRepository.save(update_user);

        return "User Updated Successfully";
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User Deleted Successfully";
    }
}
