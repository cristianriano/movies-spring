package com.cristianriano.movies.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJpaRepository<T> extends CrudRepository<T, Long> {

  default T findOne(final Long id) {
    if (id == null) {
      return null;
    }

    Optional<T> one = findById(id);
    return one.isPresent() ? one.get() : null;
  }
}
