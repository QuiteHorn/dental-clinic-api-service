package ru.meerake.serverside.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.meerake.serverside.model.User;
import ru.meerake.serverside.repository.UserRepository;
import ru.meerake.serverside.security.UserDetailsImpl;

import java.time.LocalDateTime;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(@NotNull  UserRepository userRepository, @NotNull PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(login);
        return new UserDetailsImpl(user);
    }


    public String registerUser(String username, String plainPassword, String role) {
        if (userRepository.findByUsername(username) == null) {
            String hashedPassword = passwordEncoder.encode(plainPassword);

            User user = new User();
            user.setUsername(username);
            user.setPassword(hashedPassword);
            user.setRole(role);
            user.setLastlogin(LocalDateTime.now());
            log.debug("Registering user {} {} {} {}", username, plainPassword, role, LocalDateTime.now());
            userRepository.save(user);

            return "Пользователь успешно зарегистрирован!";
        }

        return "Ошибка";
    }

    public boolean authenticateUser(String username, String plainPassword) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        if (passwordEncoder.encode(plainPassword).equals(user.getPassword())) {
            user.setLastlogin(LocalDateTime.now());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }
}
