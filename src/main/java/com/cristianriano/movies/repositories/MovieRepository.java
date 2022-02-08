package com.cristianriano.movies.repositories;

import com.cristianriano.movies.entities.Movie;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends BaseJpaRepository<Movie> {

  List<Movie> findAllByName(final String name);
}
