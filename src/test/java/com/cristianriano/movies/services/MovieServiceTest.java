package com.cristianriano.movies.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.cristianriano.movies.entities.Movie;
import com.cristianriano.movies.entities.MovieGenre;
import com.cristianriano.movies.errors.NotFoundException;
import com.cristianriano.movies.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

  private static final MovieGenre GENRE = MovieGenre.ACTION;
  private static final String NAME = "Iron Man";

  @Mock
  private MovieRepository movieRepository;

  @InjectMocks
  private MovieService movieService;

  @Test
  void returnMovieDtoById() {
    final Movie movie = new Movie(NAME, GENRE);
    when(movieRepository.findOne(anyLong())).thenReturn(movie);

    var returned = movieService.findById(9L);
    assertThat(returned.getGenre()).isEqualTo(GENRE);
    assertThat(returned.getName()).isEqualTo(NAME);
  }

  @Test
  void throwsExceptionWhenNotFound() {
    when(movieRepository.findOne(anyLong())).thenReturn(null);

    assertThatThrownBy(
        () -> movieService.findById(1L)
    ).isInstanceOf(NotFoundException.class);
  }
}
