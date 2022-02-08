package com.cristianriano.movies.dtos;

import com.cristianriano.movies.entities.MovieGenre;
import lombok.Data;

@Data
public class MovieDto {
  private final long id;
  private final String name;
  private final MovieGenre genre;
}
