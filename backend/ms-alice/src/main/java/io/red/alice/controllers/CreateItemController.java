package io.red.alice.controllers;

import io.red.alice.controllers.requests.ItemRequest;
import io.red.alice.controllers.responses.ItemResponse;
import io.red.alice.services.CreateItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/item")
public class CreateItemController {

    private final CreateItemService service;

    public CreateItemController(CreateItemService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse createItem(
            @RequestParam("photo") MultipartFile photo,
            @ModelAttribute ItemRequest request) {
        return service.createItem(request, photo);
    }
}
