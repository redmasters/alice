package io.red.alice.services;

import io.red.alice.models.Item;
import io.red.alice.repositories.ItemRepository;
import io.red.alice.responses.ItemResponse;
import org.springframework.stereotype.Service;

@Service
public class CriarItemService {

  private final ItemRepository itemRepository;

  public CriarItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public ItemResponse criarItem(ItemRequest itemRequest) {

  }
}
