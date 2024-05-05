package ru.venidiktov.listener;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.venidiktov.conditional.ConditionalOnProduction;
import ru.venidiktov.properties.IronProperties;

/**
 * Посылаем ворона когда банк начинает работать, то-есть когда контекст закончил свое построение
 */
@Slf4j
@Component
@ConditionalOnProduction
@ConditionalOnProperty(prefix = IronProperties.RavenProperties.PREFIX, name = "enabled", havingValue = "true")
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        log.warn("Отправляем ворона...");
    }
}

