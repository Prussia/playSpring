package com.prussia.test.play.spring.web.secure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;

import groovy.util.logging.Slf4j;

@EnableWebSecurity
@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		.authorizeRequests().antMatchers("/**").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin()
//		.loginPage("/login.jsp").permitAll()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.sessionFixation()
		.none()
//		.changeSessionId()
//		.migrateSession()
		
		;
	}

}
