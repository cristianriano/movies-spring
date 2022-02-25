package com.cristianriano.movies.services;

import com.cristianriano.movies.dtos.MovieDto;
import com.cristianriano.movies.entities.Movie;
import com.cristianriano.movies.errors.NotFoundException;
import com.cristianriano.movies.repositories.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(final MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<MovieDto> getAll() {
    List<MovieDto> movies = new ArrayList<>();
    movieRepository.findAll()
        .forEach(
            m -> movies.add(new MovieDto(m.getId(), m.getName(), m.getGenre()))
        );
    return movies;
  }

  public MovieDto findById(final long id) {
    final Movie movie = movieRepository.findOne(id);
    if (movie == null) {
      throw new NotFoundException("Movie not found with id " + id);
    }

    return new MovieDto(movie.getId(), movie.getName(), movie.getGenre());
  }
}
