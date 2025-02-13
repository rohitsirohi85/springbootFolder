package com.ProjectLinkedIn.connection_service.service;

import com.ProjectLinkedIn.connection_service.auth.UserContextHolder;
import com.ProjectLinkedIn.connection_service.entity.Person;
import com.ProjectLinkedIn.connection_service.repo.PersonRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectionService {

    private final PersonRepo personRepo;

    public List<Person> getFirstDegreeConnections(){
        Long userId= UserContextHolder.getCurrentUserId();
        log.info("getting first degree connection with user id : {} ",userId);
        return personRepo.getFirstDegreeConnections(userId);
    }

}
