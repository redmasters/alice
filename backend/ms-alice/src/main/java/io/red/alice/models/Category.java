package io.red.alice.model;

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
  private Long categoryId;
  @Column(name = "category_name")
  private String name;

  public Category() {
  }

  public Category(Long categoryId, String name) {
    this.categoryId = categoryId;
    this.name = name;
  }
}
