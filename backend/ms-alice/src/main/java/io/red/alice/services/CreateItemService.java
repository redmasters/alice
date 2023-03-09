package io.red.alice.services;

import io.red.alice.controllers.requests.ItemRequest;
import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.exceptions.CategoryNotFountException;
import io.red.alice.models.Category;
import io.red.alice.models.Item;
import io.red.alice.repositories.CategoryRepository;
import io.red.alice.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateItemService {

  private final ItemRepository itemRepository;
  private final CategoryRepository categoryRepository;

  private static final Logger log = LoggerFactory.getLogger(CreateItemService.class);

  public CreateItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
    this.itemRepository = itemRepository;
    this.categoryRepository = categoryRepository;
  }

  public ItemResponse createItem(ItemRequest request) {
    log.info("Criando item: {}", request);
    var category = categoryRepository.findById(request.categoryId())
        .orElseThrow(() -> new CategoryNotFountException("Category not found"));

    final var newItem = getItem(request, category);

    final var item = itemRepository.save(newItem);
    log.info("Item criado: {}", item.getName());
    return itemResponse(item);

  }

  private static Item getItem(ItemRequest request, Category category){
    return new Item(
        request.name(),
        request.description(),
        request.weight(),
        request.unit(),
        request.barCode(),
        request.dueDate(),
        new Category(
            category.getId(),
            category.getName()
        )
    );
  }

  private ItemResponse itemResponse(Item item) {
    return new ItemResponse(
        item.getId(),
        item.getName(),
        item.getDescription(),
        item.getWeight(),
        item.getUnit(),
        item.getBarCode(),
        item.getDueDate(),
        new ItemResponse.Category(
            item.getCategory().getId(),
            item.getCategory().getName()
        )
    );
  }

}
