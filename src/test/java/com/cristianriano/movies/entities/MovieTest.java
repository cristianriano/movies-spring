package com.cristianriano.movies.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MovieTest {

  @Test
  void initializeMovie() {
    final String name = "Die Hard";
    final Movie movie = new Movie(name);

    assertThat(movie.getName()).isEqualTo(name);
  }

  @Test
  void setsGenreCorrectly() {
    final Movie movie = new Movie("The Ring", MovieGenre.HORROR);
    assertThat(movie.getGenre().name()).isEqualTo("HORROR");
  }
}
