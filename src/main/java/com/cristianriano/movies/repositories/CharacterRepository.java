package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

  Character findCharacterByName(final String name);
}
