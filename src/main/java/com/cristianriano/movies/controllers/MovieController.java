package com.cristianriano.movies.controllers;

import com.cristianriano.movies.entities.Movie;
import com.cristianriano.movies.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
  private final MovieRepository repository;

  @RequestMapping("/add")
  public String add() {
    repository.save(new Movie("Die Hard"));
    return "OK";
  }
}
