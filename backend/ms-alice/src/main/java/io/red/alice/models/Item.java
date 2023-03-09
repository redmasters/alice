package io.red.alice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tbl_item")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "item_id")
  private UUID itemId;
  @Column(name = "item_name")
  private String name;
  @Column(name = "item_description")
  private String description;
  @Column(name = "item_quantity")
  private Float quantity;

  @ManyToOne
  @JoinColumn(name = "fktbl_item_category")
  private Category category;

  public Item() {
  }

  public Item(UUID itemId, String name, String description, Float quantity, Category category) {
    this.itemId = itemId;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.category = category;
  }

}
