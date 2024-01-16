package com.ziggy.hackingspringbootch1reactive.reactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController // 화면 구성 템플릿 대신, 결과 데이터를 직렬화하고 HTTP 응답 보눈에 직접 써서 반환하는 REST 컨트롤러 선언 애노테이션
public class ServerController {

    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen) { // 스프링이 빈 주입 생성자 하나라 @Autowired 생략 가능
        this.kitchen = kitchen;
    }

    // 요청을 받으면 요리를 만들고, 요리가 준비되면 클라이언트에게 전송한다.
    // /server 향하는 GET 요청을 이 메소드로 라우팅 해주는 MVC 애노테이션. 반환 미디어 타입은 text/event-stream, 클라이언트느 서버가 반환하는 스트림을 쉽게 소비 가능
    @GetMapping(value = "/server", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> serveDishes() {
        return this.kitchen.getDishes();
    }

    // text/event-stream 비동기 스트림으로 제공
    @GetMapping(value = "/served-dishes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Dish> deliverDishes() {
        return this.kitchen.getDishes()
            .map(Dish::deliver); // delivered 값이 true가 된다.
    }
}
