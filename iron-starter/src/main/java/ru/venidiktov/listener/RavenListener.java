package ru.venidiktov.listener;

import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.venidiktov.properties.IronProperties;

/**
 * Посылаем ворона когда банк начинает работать и сказано куда лететь,
 * то-есть когда контекст закончил свое построение и заполнили свойство в yml where-to-fly
 */
@Slf4j
@Component
//@ConditionalOnProduction //Выключил чтоб pop up не надоедал
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = IronProperties.RavenProperties.PREFIX, name = "where-to-fly[0]")
public class RavenListener implements ApplicationListener<ContextRefreshedEvent> {
    private final IronProperties.RavenProperties ravenProperties;

    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        ravenProperties.getWhereToFly().forEach(toFly -> log.warn("Отправляем ворона в: %s".formatted(toFly)));
    }
}

