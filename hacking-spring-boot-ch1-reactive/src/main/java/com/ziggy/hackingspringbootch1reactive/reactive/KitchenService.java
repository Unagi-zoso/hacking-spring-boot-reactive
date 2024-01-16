package com.ziggy.hackingspringbootch1reactive.reactive;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service // 스프링이 이 클래스를 빈으로 등록하고, 다른 빈에서 주입할 수 있게 해준다.
public class KitchenService {

    Flux<Dish> getDishes() { // 기존 코드에선 Flux.just() 사용해서 고정적 요리를 만들고 끝나 실제 시뮬 어려웠. generate를 사용해 연속적으로 만들어
        return Flux.<Dish> generate(sink -> sink.next(randomDish())) // 요리를 무작위로 생성하는 Flux<Dish>를 반환
                // sink는 무작위로 제공되는 요리를 둘러싼 FLux의 핸들ㄹ, Flux에 포함될 원소를 동적으로 발행한다.
                // 메소드 파라미터  타입은 Consumer<SynchronousSink<T>>이다. sink는 여기서 따와 생성된 데이터가 빠져나가는 배출구이다.
            .delayElements(Duration.ofMillis(250)); // 250ms마다 요리를 생성
    }

    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

    private final List<Dish> menu = Arrays.asList(
        new Dish("Sesame chicken"),
        new Dish("Lo mein noodles, plain"),
        new Dish("Sweet & sour beef")
    );

    private final Random picker = new Random();
}
