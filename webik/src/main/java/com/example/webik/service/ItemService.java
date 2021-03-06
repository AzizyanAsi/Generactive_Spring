package com.example.webik.service;

import com.example.webik.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item create(Item item);
    Item update(Item item);
    boolean delete(Long id);
    Optional<Item> getItem(Long id);
    List<? extends Item> getAll();
}
