package ru.chelserg.btstrap.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.chelserg.btstrap.models.Role;
import ru.chelserg.btstrap.models.User;
import ru.chelserg.btstrap.repositories.RoleRepository;
import ru.chelserg.btstrap.repositories.UserRepository;

import java.util.Set;


@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Autowired
    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role adminRole = roleRepository.findByRoleNames("ROLE_ADMIN")
                .orElseGet(() -> {
                    Role role = new Role("ROLE_ADMIN");
                    return roleRepository.save(role);
                });

        Role userRole = roleRepository.findByRoleNames("ROLE_USER")
                .orElseGet(() -> {
                    Role role = new Role("ROLE_USER");
                    return roleRepository.save(role);
                });

        User adminUser = userRepository.findByUsername("admin")
                .orElseGet(() -> {
                    User user = new User();
                      user.setUsername("admin");
                      user.setPassword(passwordEncoder.encode("admin"));
                      user.setRoles(Set.of(adminRole, userRole));
                      user.setAge(28L);
                      user.setLastName("Ivanov");
                      user.setEmail("admin@example.com");
                    return userRepository.save(user);
                });

        User regularUser = userRepository.findByUsername("user")
                .orElseGet(() -> {
                    User user = new User();
                    user.setUsername("user");
                    user.setPassword(passwordEncoder.encode("user"));
                    user.setRoles(Set.of(userRole));
                    user.setAge(24L);
                    user.setLastName("Petrov");
                    user.setEmail("user@example.com");
                    return userRepository.save(user);
                });
    }
}
