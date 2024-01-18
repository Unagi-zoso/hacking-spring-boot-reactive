package com.ziggy.hackingspringbootch2reactive.service;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import com.ziggy.hackingspringbootch2reactive.repository.ItemByExampleRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class InventoryService {
    ItemByExampleRepository itemByExampleRepository;

    public Flux<Item> searchByExample(String name, String description, boolean useAnd) {
        Item item = new Item(name, 0.0, description);

        ExampleMatcher matcher = (useAnd
                ? ExampleMatcher.matchingAll()
                : ExampleMatcher.matchingAny())
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase()
                .withIgnorePaths("price");

        Example<Item> probe = Example.of(item, matcher);

        return itemByExampleRepository.findAll(probe);
    }
}
