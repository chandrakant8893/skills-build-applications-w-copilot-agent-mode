package com.example.items.dto;

public class ItemResponse {
    private String id;
    private String name;
    private String description;
    private String createdAt;

    public ItemResponse() {}

    public ItemResponse(String id, String name, String description, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}