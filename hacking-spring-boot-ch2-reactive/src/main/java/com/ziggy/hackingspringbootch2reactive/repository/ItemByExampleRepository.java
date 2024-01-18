package com.ziggy.hackingspringbootch2reactive.repository;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ItemByExampleRepository extends ReactiveQueryByExampleExecutor<Item> {
}
