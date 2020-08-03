package com.webencyclop.app.security;

import com.webencyclop.app.security.entities.Role;
import com.webencyclop.app.security.entities.User;
import com.webencyclop.app.security.services.UserAuthenticationService;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    @Inject
    UserAuthenticationService userAuthenticationService;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@org.jetbrains.annotations.Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            Optional<User> user = checkIfUserExists(authenticationRequest);
            if (user.isPresent()) {
                emitter.onNext(getUserDetailsFromUser(user.get()));
                emitter.onComplete();
            } else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }, BackpressureStrategy.ERROR);
    }

    private Optional<User> checkIfUserExists(AuthenticationRequest<?, ?> authenticationRequest) {
        String username = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();
        return userAuthenticationService.getUserByUsernameAndPassword(username, password);
    }

    private UserDetails getUserDetailsFromUser(User user) {
        return new UserDetails(user.getUsername(), user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
    }
}
