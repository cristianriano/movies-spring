package com.cristianriano.movies.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "movies")
public class Movie {
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "movie")
  Set<Character> characters = new HashSet<>();

  Movie() {}

  public Movie(final String name) {
    this.name = name;
  }
}
