package com.ProjectLinkedIn.connection_service.repo;

import com.ProjectLinkedIn.connection_service.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends Neo4jRepository<Person , Long> {

    Optional<Person> getByName(String name);

    @Query("MATCH (personA:Person) -[:CONNECTED_TO]- (personB:Person) " +
            "WHERE personA.userId = $userId " +
            "RETURN personB")
    List<Person> getFirstDegreeConnections(Long userId);
}
