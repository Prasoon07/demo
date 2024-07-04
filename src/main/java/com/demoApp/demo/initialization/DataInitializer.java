package com.demoApp.demo.initialization;

import com.demoApp.demo.Model.User;
import com.demoApp.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            if (userRepository.count() == 0) {
                User superUser = new User();
                superUser.setName("superuser");
                superUser.setEmail("superuser@example.com");
                superUser.setPassword(passwordEncoder.encode("123456"));
                superUser.setPhone("1234567890");
                superUser.setAddress("Superuser Address");
                // Set createdAt and updatedAt if necessary, e.g., with Timestamp.valueOf(LocalDateTime.now());

                userRepository.save(superUser);
            }
        };
    }
}
