package com.example.items.service;

import com.example.items.model.Item;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ItemService {
    private final Map<String, Item> store = new ConcurrentHashMap<>();

    public Item create(String name, String description) {
        String id = UUID.randomUUID().toString();
        String createdAt = Instant.now().toString();
        Item item = new Item(id, name, description, createdAt);
        store.put(id, item);
        return item;
    }
}