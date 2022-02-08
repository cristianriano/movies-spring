package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Character;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends BaseJpaRepository<Character> {

  Character findCharacterByName(final String name);
}
