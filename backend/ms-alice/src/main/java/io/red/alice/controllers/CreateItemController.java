package io.red.alice.controllers;

import io.red.alice.controllers.requests.ItemRequest;
import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.services.CreateItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/item")
public class CreateItemController {

  private final CreateItemService service;

  public CreateItemController(CreateItemService service) {
    this.service = service;
  }

  @PostMapping
  public ItemResponse createItem(
      @RequestBody
      @Valid ItemRequest request){
    return service.createItem(request);
  }
}
