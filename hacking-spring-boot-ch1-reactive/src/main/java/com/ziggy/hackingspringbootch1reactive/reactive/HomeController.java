package com.ziggy.hackingspringbootch1reactive.reactive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller // 웹 페이지 반환 웹 컨트롤러 선언 애노테이션
public class HomeController {

    @GetMapping
    Mono<String> home() { // 템플릿의 이름을 나타내는 문자열을 리액티브 컨테이너인 Mono에 담아 반환
        return Mono.just("home"); // 화면 템플릿 의미 'home'을 Mono.just()에 감싸서 반환
    }


}
