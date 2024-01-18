package com.ziggy.hackingspringbootch2reactive.controller;

import com.ziggy.hackingspringbootch2reactive.domain.Cart;
import com.ziggy.hackingspringbootch2reactive.domain.CartItem;
import com.ziggy.hackingspringbootch2reactive.repository.CartRepository;
import com.ziggy.hackingspringbootch2reactive.repository.ItemRepository;
import com.ziggy.hackingspringbootch2reactive.service.CartService;
import com.ziggy.hackingspringbootch2reactive.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    private ItemRepository itemRepository;
    private CartRepository cartRepository;
    private CartService cartService;
    private InventoryService inventoryService;


    public HomeController(ItemRepository itemRepository, CartRepository cartRepository, CartService cartService, InventoryService inventoryService) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
        this.inventoryService = inventoryService;
    }

    @GetMapping
    Mono<Rendering> home() { // view attribute 포함하는 웹플럭스 컨테이너 Mono<Rendering> 반환
        return Mono.just(Rendering.view("home.html") // view로 렌더링할 템플릿 지정
                .modelAttribute("items", this.itemRepository.findAll().doOnNext(System.out::println)) // 템플릿에 전달할 모델 지정
                .modelAttribute("cart", this.cartRepository.findById("My Cart")
                        .defaultIfEmpty(new Cart("My Cart"))) // 장바구니가 없으면 새로 만든다.
                .build());
    }

    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id) {
        return cartService.addToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

    @GetMapping("/search")
    Mono<Rendering> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam boolean useAnd) {
        return Mono.just(Rendering.view("home.html")
                .modelAttribute("items", inventoryService.searchByExample(name, description, useAnd))
                .build());
    }
}
