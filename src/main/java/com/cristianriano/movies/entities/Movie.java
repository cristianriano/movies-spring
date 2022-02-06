package com.cristianriano.movies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "movies")
public class Movie {
  @Id
  @GeneratedValue
  private long id;
  private String name;

  public Movie(final String name) {
    this.name = name;
  }

  Movie() {}
}
