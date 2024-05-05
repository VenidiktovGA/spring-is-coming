package ru.venidiktov.springiscoming;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.venidiktov.springiscoming.properties.ProphetProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProphetProperties.class)
public class IronBankApplication {

    public static void main(String[] args) {
        /**
         * Добавил для решения exception java.awt.HeadlessException
         * https://stackoverflow.com/questions/49619353/caused-by-java-awt-headlessexception-when-trying-to-create-a-swing-awt-frame-fr
         */
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IronBankApplication.class);
        builder.headless(false);
        builder.run(args);
    }
}
