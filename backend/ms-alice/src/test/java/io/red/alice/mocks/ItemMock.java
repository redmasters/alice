package io.red.alice.mocks;

import io.red.alice.controllers.requests.ItemRequest;
import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.models.Category;
import io.red.alice.models.Item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemMock {

  public static Item createItem(){
    return new Item(
        UUID.fromString("c0a80101-0000-0000-0000-000000000000"),
        "Item 1",
        "Item 1 description",
        1.0,
        "kg",
        "123456789",
        LocalDate.now(),
        new Category(
            1L,
            "Category 1"
        )
    );
  }
  public static ItemResponse itemResponse(){
    return new ItemResponse(
        createItem().getId(),
        "Item 1",
        "Item 1 description",
        1.0,
        "kg",
        "123456789",
        LocalDate.now(),
        new ItemResponse.Category(
            1L,
            "Category 1"
        )
    );
  }

  public static ItemRequest itemRequest() {
    return new ItemRequest(
        "Item 1",
        "Item 1 description",
        1.0,
        "kg",
        "123456789",
        LocalDate.now(),
        1L);
  }
}
