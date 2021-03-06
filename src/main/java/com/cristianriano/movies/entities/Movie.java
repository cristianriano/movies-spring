package com.cristianriano.movies.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

  @OneToMany(
      mappedBy = "movie",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY
  )
  private Set<Character> characters = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column(name = "genre")
  private MovieGenre genre;

  Movie() {}

  public Movie(final String name) {
    this(name, null);
  }

  public Movie(final String name, final MovieGenre genre) {
    this.name = name;
    this.genre = genre;
  }

  // Since we have bidirectional relationships we need to make sure to keep in sync both ends
  public Movie addCharacter(final Character character) {
    characters.add(character);
    character.setMovie(this);
    return this;
  }

  public Movie removeCharacter(final Character character) {
    characters.remove(character);
    character.setMovie(null);
    return this;
  }
}
