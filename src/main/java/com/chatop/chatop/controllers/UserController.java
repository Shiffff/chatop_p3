package com.chatop.chatop.controllers;


import com.chatop.chatop.dto.AuthentificationDTO;
import com.chatop.chatop.entity.User;
import com.chatop.chatop.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private AuthenticationManager authenticationManager;
    private UserService userService;

    @PostMapping(path = "register")
    public void register(@RequestBody User user) {
        log.info("inscription");
        this.userService.register(user);
    }

    @PostMapping(path = "login")
    public Map<String, String> login(@RequestBody AuthentificationDTO authentificationDTO){
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(), authentificationDTO.password())
        );
        log.info("resultat {}", authenticate.isAuthenticated());
        return null;
    }

}
