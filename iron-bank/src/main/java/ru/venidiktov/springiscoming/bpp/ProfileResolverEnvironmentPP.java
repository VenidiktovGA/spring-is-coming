package ru.venidiktov.springiscoming.bpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.venidiktov.springiscoming.constant.ProfileConstants;

import java.util.Random;


/**
 * Работники Железного Банка ленивы и не хотят устанавливать профиль, если профиль не установлен работником
 * приложение должно само его установить относительно температуры
 * <p>
 * В данный момент нет даже контекста приложения есть только environment
 * Не нашел как зарегать этот класс через SpringApplicationBuilder пришлось добавить в файл spring.factories
 */
public class ProfileResolverEnvironmentPP implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String profile;
        var temperature = getTemperature();
        if (environment.getActiveProfiles().length == 0 && temperature < -60) {
            profile = ProfileConstants.ЗИМА_ТУТА;
        } else {
            profile = ProfileConstants.ЗИМА_БЛИЗКО;
        }
        System.out.printf("!$$$ Внимание температура %s градуса для нее выбран профиль '%s' $$$!%n", temperature, profile);
        environment.setActiveProfiles(profile);
    }

    public int getTemperature() {
        return new Random().nextInt(-90, 60);
    }
}
