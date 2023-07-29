package io.red.alice.controllers.responses;

import java.time.LocalDate;
import java.util.UUID;

public record ItemResponse(
  UUID itemId,
  String name,
  String description,
  double weight,
  String unit,
  String barCode,
  String pathPhoto,
  LocalDate dueDate,
  Category category
) {
  public record Category(
   Long id,
   String name
  ){}
}
