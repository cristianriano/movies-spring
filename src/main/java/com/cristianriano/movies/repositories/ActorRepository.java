package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

}
