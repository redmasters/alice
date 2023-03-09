package io.red.alice.services;

import io.red.alice.mocks.ItemMock;
import io.red.alice.repositories.CategoryRepository;
import io.red.alice.repositories.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class CreateItemServiceTest {

  @Mock
  ItemRepository itemRepository;
  @Mock
  CategoryRepository categoryRepository;
  @InjectMocks
  CreateItemService createItemService;

  @Test
  @DisplayName("Should create a new item")
  void shouldCreateANewItem() {
   var newItem = ItemMock.createItem();

   assertNotNull(newItem);
   assertEquals(newItem.getId(), UUID.fromString("c0a80101-0000-0000-0000-000000000000"));
   assertEquals(newItem.getName(), "Item 1");
  }


}

