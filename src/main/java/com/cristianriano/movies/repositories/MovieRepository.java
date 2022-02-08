package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

  List<Movie> findAllByName(final String name);
}
