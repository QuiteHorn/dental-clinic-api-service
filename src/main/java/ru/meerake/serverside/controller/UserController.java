package ru.meerake.serverside.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.meerake.serverside.dto.LoginRequest;
import ru.meerake.serverside.dto.RegisterRequest;
import ru.meerake.serverside.security.JwtAuthenticationResponse;
import ru.meerake.serverside.service.AuthenticationService;
import ru.meerake.serverside.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(userService.registerUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getRole()));
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
        }
}
