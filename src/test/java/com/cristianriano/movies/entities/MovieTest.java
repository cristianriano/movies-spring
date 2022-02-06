package com.cristianriano.movies.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MovieTest {

  @Test
  void initializeMovie() {
    final String name = "Die Hard";
    final long id = 1L;
    final Movie movie = new Movie(id, name);

    assertThat(movie.getId()).isEqualTo(id);
    assertThat(movie.getName()).isEqualTo(name);
  }
}
