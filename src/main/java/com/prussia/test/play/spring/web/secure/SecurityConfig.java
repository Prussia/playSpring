package com.prussia.test.play.spring.web.secure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import groovy.util.logging.Slf4j;

@EnableWebSecurity
@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    
}
