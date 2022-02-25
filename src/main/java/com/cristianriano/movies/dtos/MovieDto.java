package com.cristianriano.movies.dtos;

import com.cristianriano.movies.entities.MovieGenre;
import lombok.Data;

@Data
public class MovieDto {
  private final Long id;
  private final String name;
  private final MovieGenre genre;
}
