package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
