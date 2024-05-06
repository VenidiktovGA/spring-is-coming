package ru.venidiktov.springiscoming.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import ru.venidiktov.springiscoming.constant.ProfileConstants;

/**
 * Железный Банк имеет разную логику работы когда зима близко и когда зима тута,
 * соответственно это два профиля, запустить приложения без профиля нельзя
 * Тут мы смотрим есть ли установленный профиль из тех что разрешен
 */
public class ProfileCheckInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        if (environment.getActiveProfiles().length == 0) {
            var errorMessage = "Железный банк не может работать без профиля!\n Профили: %s, %s".formatted(
                    ProfileConstants.ЗИМА_БЛИЗКО, ProfileConstants.ЗИМА_ТУТА);
            throw new RuntimeException(errorMessage);
        }
    }
}
