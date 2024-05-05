package ru.venidiktov.properties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

@Slf4j
@Getter
@Setter
@ToString(callSuper = true)
@ConfigurationProperties(IronProperties.PREFIX)
public class IronProperties {
    public static final String PREFIX = "iron-starter";

    private boolean enabled;
    @NestedConfigurationProperty
    private RavenProperties raven = new RavenProperties();

    @PostConstruct
    public void toLog() {
        log.info("{} properties: {}", PREFIX, this);
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @ConfigurationProperties(RavenProperties.PREFIX)
    public static class RavenProperties {
        public static final String PREFIX = IronProperties.PREFIX + ".raven";

        private List<String> whereToFly;
    }
}
