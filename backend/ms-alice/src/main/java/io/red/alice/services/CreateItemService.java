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
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class CreateItemService {

  private final ItemRepository itemRepository;
  private final CategoryRepository categoryRepository;
  private final StorageService storageService;

  private static final Logger logger = LoggerFactory.getLogger(CreateItemService.class);
  private static final String NO_DATA= "NO_DATA";

  public CreateItemService(ItemRepository itemRepository, CategoryRepository categoryRepository, StorageService storageService) {
    this.itemRepository = itemRepository;
    this.categoryRepository = categoryRepository;
    this.storageService = storageService;
  }

  public ItemResponse createItem(ItemRequest request, MultipartFile photo) {
    logger.info("Criando item: {}", request);
    var category = categoryRepository.findById(request.categoryId())
        .orElseThrow(() -> new CategoryNotFountException("Category not found"));

    var pathPhoto = storageService.store(photo) == null ? Path.of(NO_DATA) : storageService.store(photo);
    final var newItem = getItem(request, pathPhoto.toString(), category);

    final var item = itemRepository.save(newItem);
    logger.info("Item criado: {}", item.getName());
    return itemResponse(item);

  }

  private static Item getItem(ItemRequest request, String photo, Category category){
    return new Item(
        request.name(),
        request.description(),
        request.weight(),
        request.unit(),
        request.barCode(),
        photo,
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
        item.getPhoto(),
        item.getDueDate(),
        new ItemResponse.Category(
            item.getCategory().getId(),
            item.getCategory().getName()
        )
    );
  }

}
