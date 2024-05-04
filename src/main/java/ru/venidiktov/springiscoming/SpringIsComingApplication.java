package ru.venidiktov.springiscoming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.venidiktov.springiscoming.properties.ProphetProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProphetProperties.class)
public class SpringIsComingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIsComingApplication.class, args);
    }
}
