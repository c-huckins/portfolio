package com.mysite.portfolio.configurations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "development")
@NoArgsConstructor
@Getter
@Setter
public class ProjectProperties {
    private String stage;
    private String mongoDbUri;
}