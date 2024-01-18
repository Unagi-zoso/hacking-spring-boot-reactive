package com.ziggy.hackingspringbootch2reactive.repository;

import com.ziggy.hackingspringbootch2reactive.domain.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<Cart, String> {
}
