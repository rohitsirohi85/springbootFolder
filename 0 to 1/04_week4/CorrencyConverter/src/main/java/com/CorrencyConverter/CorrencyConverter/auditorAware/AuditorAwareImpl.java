package com.CorrencyConverter.CorrencyConverter.auditorAware;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {  //we use string here coz we want the name of user who changed something we could change it to long(for id) or anything else depends on usecase

    @Override
    public Optional<String> getCurrentAuditor() {
        // get security context
        // get authentication
        // get principle
        // get username
        return Optional.of("Rohit sirohi");   // this is not the right way , user has to fetch by spring security but we will learn it later
    }
}
