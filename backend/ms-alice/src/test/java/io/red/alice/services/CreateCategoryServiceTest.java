package io.red.alice.services;

import io.red.alice.mocks.CategoryMock;
import io.red.alice.models.Category;
import io.red.alice.repositories.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class CreateCategoryServiceTest {

  @Mock
  CategoryRepository categoryRepository;
  @InjectMocks
  CreateCategoryService createCategoryService;

  @Test
  @DisplayName("Should create a new category")
  void shouldCreateANewCategory() {
    var newCategory = CategoryMock.createCategory();
    assertNotNull(newCategory);
    assertEquals(newCategory.getId(), 1L);
    assertEquals(newCategory.getName(), "Category 1");
  }

  @Test
  @DisplayName("Should save a new category")
  void shouldSaveANewCategory() {
    var newCategory = CategoryMock.createCategory();

    when(categoryRepository.save(any(Category.class)))
        .thenReturn(newCategory);

  }

  @Test
  @DisplayName("Should create and save a new category")
  void shouldCreateAndSaveANewCategory() {
    var newCategory = CategoryMock.createCategory();
    var request = CategoryMock.request();

    when(categoryRepository.save(any(Category.class)))
        .thenReturn(newCategory);

    var category = createCategoryService.createCategory(request);

    assertNotNull(category);
    assertEquals(category.getId(), 1L);
    assertEquals(category.getName(), "Category 1");
  }


}
