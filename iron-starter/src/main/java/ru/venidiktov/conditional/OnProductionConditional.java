package ru.venidiktov.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;

/**
 * Определение продакш это окружение или нет
 * Логика по самописным Conditional:
 * Вызовется 1 раз если Conditional в starter'е/приложении поставить над компонентом созданным через метод помеченный @Bean
 * Вызовется 3 раз если Conditional в starter'е поставить над компонентом @Configuration, @Service, @Component и т.д.
 * Вызовется 4 раз если Conditional в приложении поставить над компонентом @Configuration, @Service, @Component и т.д.
 * Таким образом логика в Conditional дорогая ее самому следует кэшировать!
 */
@Slf4j
public class OnProductionConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        log.warn("OnProductionConditional");
        return JOptionPane.showConfirmDialog(null, "Это продакшн?") == 0;
    }
}
