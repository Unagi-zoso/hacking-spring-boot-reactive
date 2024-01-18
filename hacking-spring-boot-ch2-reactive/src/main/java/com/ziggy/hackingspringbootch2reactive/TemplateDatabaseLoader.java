package com.ziggy.hackingspringbootch2reactive;

import com.ziggy.hackingspringbootch2reactive.domain.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.jmx.export.metadata.ManagedOperation;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {

    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new Item("Alf alarm clock", 19.99, "초유명 시계"));
            mongo.save(new Item("Smurf TV tray", 24.99, "초유명 TV용 트레이"));
        };
    }

}
