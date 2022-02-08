package com.cristianriano.movies.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "actors")
@Getter
public class Actor {
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;

  // We use the name of the relationship on the other entity where the join columns are
  @OneToMany(
      mappedBy = "actor",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY
  )
  Set<Character> characters = new HashSet<>();

  Actor() {}

  public Actor(final String name) {
    this.name = name;
  }

  public Actor addCharacter(final Character character) {
    characters.add(character);
    character.setActor(this);
    return this;
  }

  public Actor removeCharacter(final Character character) {
    characters.remove(character);
    character.setActor(null);
    return this;
  }
}
