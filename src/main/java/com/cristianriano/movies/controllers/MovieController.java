package com.cristianriano.movies.controllers;

import com.cristianriano.movies.dtos.MovieDto;
import com.cristianriano.movies.entities.Movie;
import com.cristianriano.movies.services.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// RestController marks the class as a controller where every method returns a domain object instead of a view
// It is shorthand for including both @Controller and @ResponseBody.
// Spring’s HTTP message converter support, uses MappingJackson2HttpMessageConverter automatically because Jackson 2 is on the classpath.
@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

  private final MovieService movieService;

  @GetMapping()
  public List<MovieDto> getAll() {
    return movieService.getAll();
  }

  @GetMapping("/{id}")
  public MovieDto get(@PathVariable final long id) {
    return movieService.findById(id);
  }
}
