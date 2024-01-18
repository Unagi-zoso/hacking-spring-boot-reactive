package com.ziggy.hackingspringbootch2reactive;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import com.ziggy.hackingspringbootch2reactive.repository.BlockingItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// @Component 리액티브 환경에서 블로킹 방식은 쓰면 안돼
public class RepositoryDatabaseLoader {

    @Bean // 메소드가 반환하는 객체가 빈에 등록되게 해주는 애노테이션
        // CommandLineRunner는 앱 시장되고자동 실행되는 특수 스프링 부트 컴포넌트, run 메소드 하나 가진 함수형 인터페이스 모든 컴포넌트 등록되고 활성화된 이후 run() 실행 보장
    CommandLineRunner initialize(BlockingItemRepository repository) {
        return args -> { // CommandLineRunner가 함수형 인터페이스라 익명 서브클래스 생성 없이 람다식으로 처리. 이때 생성한다.
            //repository.save(new Item("Alf alarm clock", 19.99));
            //repository.save(new Item("Smurf TV tray", 24.99));
        };
    }
    // 여러 CommandLineRunner 객체 사이엔 순서 보장 없다.
}
