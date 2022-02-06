package com.cristianriano.movies.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "movies")
public class Movie {
  @Id
  @GeneratedValue
  private long id;
  private String name;

  Movie() {}
}
