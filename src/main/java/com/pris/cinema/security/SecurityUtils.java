package com.pris.cinema.security;

import com.pris.cinema.entities.ERole;
import com.pris.cinema.entities.User;
import com.pris.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityUtils {

    @Autowired private UserRepository userRepository;

    public boolean checkRole(ERole role) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> principal = userRepository.findByUsername(authentication.getName());

        return principal.isPresent() && principal.get().getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(SecurityConstants.ROLE_PREFIX + role));
    }

    public ERole getRole() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> principal = userRepository.findByUsername(authentication.getName());

        return principal.isPresent() ? principal.get().roleAsEnum() : null;
    }

    public User getSelf() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> principal = userRepository.findByUsername(authentication.getName());

        return principal.isPresent() ? principal.get() : null;
    }
}
