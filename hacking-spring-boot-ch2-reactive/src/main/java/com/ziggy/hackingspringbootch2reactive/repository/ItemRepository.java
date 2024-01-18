package com.ziggy.hackingspringbootch2reactive.repository;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveCrudRepository<Item, String> {
    // 몽고디비나 JPA 메소드 이름 규칙만 잘 활용하면 스프링 데이터가 개발자 대신해 쿼리를 만들어준다.
    // containing : like 검색
    Flux<Item> findByNameContaining(String partialName);
}
