package com.ziggy.hackingspringbootch2reactive.repository;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import org.springframework.data.repository.CrudRepository;
// 완전한 리액티브 앱에서 블로킹 리포지토리는 쓰면 안돼
public interface BlockingItemRepository {// extends CrudRepository<Item, String> {
}
