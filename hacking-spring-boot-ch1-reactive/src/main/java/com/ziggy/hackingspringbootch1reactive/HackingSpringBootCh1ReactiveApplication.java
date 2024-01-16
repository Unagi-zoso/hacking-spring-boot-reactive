package com.ziggy.hackingspringbootch1reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 자동설정, 컴포넌트 탐색 기능 포함 복합 애너테이션
public class HackingSpringBootCh1ReactiveApplication {

    public static void main(String[] args) {
        // 이 코드는 이 클래스를 애플리케이션 시작점으로 등록하는 스프링 부트 훅한다.
        SpringApplication.run(HackingSpringBootCh1ReactiveApplication.class, args);
    }

}
