package com.cristianriano.movies.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.cristianriano.movies.entities.Actor;
import com.cristianriano.movies.entities.Character;
import com.cristianriano.movies.entities.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CharacterRepositoryTest {

  @Autowired
  private CharacterRepository repository;

  @Test
  void assignsRelationshipsCorrectly() {
    final String actorName = "Bruce Willis";
    final Actor actor = new Actor(actorName);

    final String movieName = "Die Hard";
    final Movie movie = new Movie(movieName);

    final String name = "John McClane";
    final Character john = new Character(name, true);
    john.setActor(actor);
    john.setMovie(movie);

    repository.save(john);

    final Character found = repository.findCharacterByName(name);
    assertThat(found).isNotNull();
    assertThat(found.getName()).isEqualTo(name);
    assertThat(found.getActor().getName()).isEqualTo(actorName);
    assertThat(found.getMovie().getName()).isEqualTo(movieName);
  }
}
