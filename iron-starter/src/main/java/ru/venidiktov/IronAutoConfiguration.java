package ru.venidiktov;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.venidiktov.properties.IronProperties;

@Slf4j
@Configuration
@ComponentScan
@EnableConfigurationProperties({IronProperties.class, IronProperties.RavenProperties.class})
@ConditionalOnProperty(prefix = IronProperties.PREFIX, name = "enabled", havingValue = "true")
public class IronAutoConfiguration {
    static {
        log.warn("IronConfiguration");
    }
}
