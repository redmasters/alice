package io.red.alice.mocks;

import io.red.alice.controllers.requests.CategoryRequest;
import io.red.alice.models.Category;

public class CategoryMock {
  public static Category createCategory() {
    return new Category(
        1L,
        "Category 1"
    );
  }

  public static CategoryRequest request() {
    return new CategoryRequest(
        "Category 1"
   );
  }
}
