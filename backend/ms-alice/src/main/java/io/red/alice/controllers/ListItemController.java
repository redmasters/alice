package io.red.alice.controllers;

import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.services.ListItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/v1/item")
public class ListItemController {
    private static final Logger logger = LoggerFactory.getLogger(ListItemController.class);
    private final ListItemService listItemService;

    public ListItemController(ListItemService listItemService) {
        this.listItemService = listItemService;
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<ItemResponse> listItems(){
        logger.info("Listing items");
        return listItemService.listItem();

    }
}
