package io.red.alice.models;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "tbl_category")
public class Category {
  @Id
  @GeneratedValue(strategy = SEQUENCE)
  @Column(name = "category_id")
  private Long id;
  @Column(name = "category_name")
  private String name;

  public Category() {
  }

  public Category(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Category(String name) {
    this.name = name;
  }

  public Category(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }

}
