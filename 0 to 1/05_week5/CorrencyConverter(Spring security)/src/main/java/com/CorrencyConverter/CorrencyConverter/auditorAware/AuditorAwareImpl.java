package com.CorrencyConverter.CorrencyConverter.auditorAware;

import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {  //we use string here coz we want the name of user who changed something we could change it to long(for id) or anything else depends on usecase

    @Override
    public Optional<String> getCurrentAuditor() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            return Optional.of("SYSTEM");
        }

        Object principal = auth.getPrincipal();

        // Unwrap Optional if user was incorrectly wrapped
        if (principal instanceof Optional<?> optional) {
            principal = optional.orElse(null);
        }

        if (principal instanceof UserEntity user) {
            return Optional.ofNullable(user.getEmail()); // or user.getUsername()
        }

        return Optional.of(auth.getName());
    }
}