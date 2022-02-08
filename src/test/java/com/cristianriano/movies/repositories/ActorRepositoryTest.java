package com.cristianriano.movies.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.cristianriano.movies.entities.Actor;
import com.cristianriano.movies.entities.Character;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorRepositoryTest {

  @Autowired
  private ActorRepository actorRepository;
  @Autowired
  private CharacterRepository characterRepository;

  @Test
  void whenAdd_keepsInSyncTheRelationships() {
    final Character deadpool = new Character("Deadpool", true);
    final Actor actor = new Actor("Ryan Reynolds")
        .addCharacter(deadpool)
        .addCharacter(new Character("Guy", true));

    actorRepository.save(actor);
    assertThat(characterRepository.count()).isEqualTo(2);

    actor.removeCharacter(deadpool);
    actorRepository.save(actor);
    assertThat(characterRepository.count()).isEqualTo(1);
  }
}
