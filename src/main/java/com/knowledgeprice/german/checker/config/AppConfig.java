package com.knowledgeprice.german.checker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.knowledgeprice.german")
@PropertySource("classpath:config.properties")
public class AppConfig {

}
