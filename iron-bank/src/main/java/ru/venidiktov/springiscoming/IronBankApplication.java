package ru.venidiktov.springiscoming;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.venidiktov.springiscoming.initializer.ProfileCheckInitializer;
import ru.venidiktov.springiscoming.properties.IronBankProperties;

@SpringBootApplication
@EnableConfigurationProperties(IronBankProperties.class)
public class IronBankApplication {

    public static void main(String[] args) {
        /**
         * Добавил для решения exception java.awt.HeadlessException
         * https://stackoverflow.com/questions/49619353/caused-by-java-awt-headlessexception-when-trying-to-create-a-swing-awt-frame-fr
         */
        SpringApplicationBuilder builder = new SpringApplicationBuilder(IronBankApplication.class);
        builder.headless(false);
        /**
         * Так как ProfileCheckInitializer должен отработать до того как начнут создаваться бины
         * ProfileCheckInitializer отработает когда контекст создан но в нем нет ничего кроме Environment
         */
        builder.initializers(new ProfileCheckInitializer());
        builder.run(args);
    }
}
