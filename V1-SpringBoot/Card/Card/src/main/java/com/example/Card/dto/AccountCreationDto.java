package com.example.Card.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "account")
public record AccountCreationDto(String message,
                                 Map<String, String> contactDetails,
                                 List<String> onCallSupport) {

}
