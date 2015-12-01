package com.prussia.test.play.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Thymeleaf samples
 * Add the following in pom.xml
 *  	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
 *
 */
@Controller
public class GreetingsController {
	@RequestMapping("/greetings")
	public String greetingTp(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greetingTp";
	}
}
