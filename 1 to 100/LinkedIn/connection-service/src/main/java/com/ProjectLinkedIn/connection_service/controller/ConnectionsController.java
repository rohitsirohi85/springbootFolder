package com.ProjectLinkedIn.connection_service.controller;


import com.ProjectLinkedIn.connection_service.entity.Person;
import com.ProjectLinkedIn.connection_service.service.ConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class ConnectionsController {

    private final ConnectionService connectionService;

    @GetMapping("/first-degree")
    public ResponseEntity<List<Person>> getFirstConnections(){
        return ResponseEntity.ok(connectionService.getFirstDegreeConnections());
    }

}
