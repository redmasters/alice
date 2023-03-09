package io.red.alice.controllers;

import io.red.alice.controllers.requests.CategoryRequest;
import io.red.alice.models.Category;
import io.red.alice.services.CreateCategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class CreateCategoryController {
  private final CreateCategoryService service;

  public CreateCategoryController(CreateCategoryService service) {
    this.service = service;
  }

  @PostMapping
  public Category createCategory(
      @RequestBody
      @Valid
      @NotNull(message = "Necessario nomear a categoria")
      CategoryRequest request){
    return service.createCategory(request);
  }
}
