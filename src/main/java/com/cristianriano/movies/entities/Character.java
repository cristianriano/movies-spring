package com.cristianriano.movies.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
public class Character {
  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;

  @Column(name = "is_lead")
  private boolean isLead = false;

  // ManyToOne are EAGER by default (same as OneToOne) but we add it explicitly
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "actor_id")
  @Setter
  private Actor actor;

  // Cascade saves/delete/update the movie when the character record does
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "movie_id")
  @Setter
  private Movie movie;

  Character() {}

  public Character(final String name, final boolean isLead) {
    this.name = name;
    this.isLead = isLead;
  }

  public Character(final String name) {
    this(name, false);
  }
}
