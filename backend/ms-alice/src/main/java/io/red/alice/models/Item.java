package io.red.alice.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tbl_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private UUID id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "item_description")
    private String description;
    @Column(name = "item_weight")
    private double weight;
    @Column(name = "item_unit")
    private String unit;
    @Column(name = "item_photo")
    private String photo;
    @Column(name = "item_bar_code")
    private String barCode;
    @Column(name = "item_due_date")
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name = "fktbl_item_category")
    private Category category;

    public Item() {
    }

    public Item(
            UUID id, String name, String description, double weight, String unit, String barCode,
            String photo, LocalDate dueDate, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.unit = unit;
        this.barCode = barCode;
        this.photo = photo;
        this.dueDate = dueDate;
        this.category = category;
    }

    public Item(
            String name, String description, double weight, String unit, String barCode,
            String photo, LocalDate dueDate,
            Category category) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.unit = unit;
        this.barCode = barCode;
        this.photo = photo;
        this.dueDate = dueDate;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getUnit() {
        return unit;
    }

    public String getBarCode() {
        return barCode;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Category getCategory() {
        return category;
    }

    public String getPhoto() {
        return photo;
    }
}
