package com.webencyclop.app.security.services;


import com.webencyclop.app.security.entities.User;
import com.webencyclop.app.security.repositories.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserAuthenticationService {

    @Inject
    private UserRepository userRepository;

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        List<User> users = userRepository.findByUsernameAndPassword(username, password);
        Optional<User> user = Optional.empty();
        if (users != null && users.size() > 0) {
            user = Optional.of(users.get(0));
        }
        user.ifPresent(value -> value.setPassword(""));
        return user;
    }
}
