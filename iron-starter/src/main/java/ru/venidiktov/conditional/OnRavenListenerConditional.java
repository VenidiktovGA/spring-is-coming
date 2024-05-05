package ru.venidiktov.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import ru.venidiktov.listener.RavenListener;

/**
 * Если в Железном банке своя служба воронов отнаследованная от нашей значит наших воронов отправлять не нужно
 */
public class OnRavenListenerConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().getBeanNamesForType(RavenListener.class).length == 0;
    }
}
