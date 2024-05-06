package ru.venidiktov.springiscoming.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "iron-bank")
public record IronBankProperties(
        List<String> repayDebts
) {
}
