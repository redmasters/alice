package io.red.alice.services;

import io.red.alice.controllers.requests.CategoryRequest;
import io.red.alice.models.Category;
import io.red.alice.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService {
  private static final Logger log = LoggerFactory.getLogger(CreateCategoryService.class);
  private final CategoryRepository categoryRepository;

  public CreateCategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category createCategory(CategoryRequest request) {
    log.info("Criando nova categoria: {}", request.name());

    final var newCategory = new Category(
        request.name()
    );

    log.info("Categoria criada: {}", newCategory);
    return categoryRepository.save(newCategory);
  }
}
