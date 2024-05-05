package ru.venidiktov.springiscoming.listener;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.venidiktov.listener.RavenListener;
import ru.venidiktov.properties.IronProperties;

/**
 * Вороны из iron-starter не должен отправляться, должны лететь белые вороны.
 * Достигается за счет самописного @ConditionalOnRavenListener,
 * так же поле ravenProperties сделал protected чтоб видеть его в наследниках
 */
@Slf4j
@Component //Раскоментить чтоб банк использовал белых воронов а не из iron-starter
public class WhiteRavenListener extends RavenListener {

    public WhiteRavenListener(IronProperties.RavenProperties ravenProperties) {
        super(ravenProperties);
    }

    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        ravenProperties.getWhereToFly().forEach(toFly -> log.warn("Отправляем белого ворона в: %s".formatted(toFly)));
    }
}
