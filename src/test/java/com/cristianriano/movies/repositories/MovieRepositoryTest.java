package com.cristianriano.movies.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.cristianriano.movies.entities.Movie;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Provides a bridge between Spring Boot test features and JUnit
@ExtendWith(SpringExtension.class)
// Standard test setup (H2 config, Hibernate, Spring Data, DataSource, EntityScan and logs)
// Otherwise it can't find the repo which is implemented by Spring
@DataJpaTest
public class MovieRepositoryTest {

  private static final String NAME = "Die Hard";

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  void saveAndRetrieve() {
    final Movie movie = buildMovie();
    movieRepository.save(movie);

    assertThat(movieRepository.count()).isEqualTo(1);
  }

  @Test
  void findById() {
    final Movie movie = buildMovie();
    entityManager.persistAndFlush(movie);

    final Optional<Movie> found = movieRepository.findById(movie.getId());
    assertThat(found.isPresent()).isTrue();
    assertThat(found.get().getName()).isEqualTo(NAME);
  }

  private Movie buildMovie() {
    return new Movie(NAME);
  }
}
