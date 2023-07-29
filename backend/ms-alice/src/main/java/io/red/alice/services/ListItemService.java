package io.red.alice.services;

import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.models.Item;
import io.red.alice.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListItemService {
    private static final Logger logger = LoggerFactory.getLogger(ListItemService.class);
    private final ItemRepository itemRepository;

    public ListItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponse> listItem(){
        logger.info("Listing items");
        List<ItemResponse> items = new ArrayList<>();
        for(Item item : itemRepository.findAll()){
            var response = new ItemResponse(
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
            items.add(response);

        }
        return items;
    }
}
