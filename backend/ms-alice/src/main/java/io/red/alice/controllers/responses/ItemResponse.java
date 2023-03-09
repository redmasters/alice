package io.red.alice.responses;

public record ItemResponse(
  Long itemId,
  String name,
  String description,
  Float quantity,
  Long categoryId
) {
}
