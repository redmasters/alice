package io.red.alice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
