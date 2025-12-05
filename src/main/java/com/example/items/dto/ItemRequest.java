package com.example.items.dto;

import jakarta.validation.constraints.NotBlank;

public class ItemRequest {
    @NotBlank
    private String name;
    private String description;

    public ItemRequest() {}

    public ItemRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}