package ru.venidiktov.conditional;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import ru.venidiktov.properties.IronProperties;

/**
 * Так как аннотации @Conditional... не repeatable то нельзя указать их несколько над бином, но
 * выход есть это AllNestedConditions или AnyNestedConditions
 */
public class OnRavenConditional extends AllNestedConditions {
    public OnRavenConditional() {
        super(ConfigurationPhase.PARSE_CONFIGURATION); //!!! На фазе ConfigurationPhase.REGISTER_BEAN не отработает!!!
    }

    @ConditionalOnProperty(prefix = IronProperties.RavenProperties.PREFIX, name = "where-to-fly[0]")
    public static class OnWhereToFly {
    }

    @ConditionalOnProperty(prefix = IronProperties.RavenProperties.PREFIX, name = "enabled", havingValue = "true")
    public static class OnRavenEnabled {
    }
}
