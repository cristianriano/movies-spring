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
    movieRepository.findAll().forEach(this::toDto);
    return movies;
  }

  public MovieDto findById(final long id) {
    final Movie movie = movieRepository.findOne(id);
    if (movie == null) {
      throw new NotFoundException("Movie not found with id " + id);
    }

    return toDto(movie);
  }

  public MovieDto create(final MovieDto dto) {
    final Movie movie = toMovie(dto);
    movieRepository.save(movie);
    return toDto(movie);
  }

  private MovieDto toDto(Movie movie) {
    return new MovieDto(movie.getId(), movie.getName(), movie.getGenre());
  }

  private Movie toMovie(MovieDto dto) {
    return new Movie(dto.getName(), dto.getGenre());
  }
}
