package com.example.items.controller;

import com.example.items.dto.ItemRequest;
import com.example.items.dto.ItemResponse;
import com.example.items.model.Item;
import com.example.items.service.ItemService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@Valid @RequestBody ItemRequest request) {
        Item item = itemService.create(request.getName(), request.getDescription());
        ItemResponse response = new ItemResponse(item.getId(), item.getName(), item.getDescription(), item.getCreatedAt());
        return ResponseEntity.status(201).body(response);
    }
}