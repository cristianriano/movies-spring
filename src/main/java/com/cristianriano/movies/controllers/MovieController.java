package com.cristianriano.movies.controllers;

import com.cristianriano.movies.entities.Movie;
import com.cristianriano.movies.entities.MovieGenre;
import com.cristianriano.movies.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController marks the class as a controller where every method returns a domain object instead of a view
// It is shorthand for including both @Controller and @ResponseBody.
// Spring’s HTTP message converter support, uses MappingJackson2HttpMessageConverter automatically because Jackson 2 is on the classpath.
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
  private final MovieRepository repository;

  @RequestMapping("/add")
  public String add() {
    repository.save(new Movie("Die Hard", MovieGenre.ACTION));
    return "OK";
  }

  @RequestMapping("/all")
  public Iterable<Movie> all() {
    return repository.findAll();
  }
}
