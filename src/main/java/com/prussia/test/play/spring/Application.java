package com.prussia.test.play.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.prussia.test.play.spring.domain.Quote;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		printBeanDef(context);
	}

	private static void printBeanDef(ApplicationContext context) {
		int i = 0;
		for (String bean : context.getBeanDefinitionNames()) {
			i++;
			System.out.println(i + "." + bean);
		}

		int count = context.getBeanDefinitionCount();

		System.out.println("Total bean count: " + count);
	}

	/**
	 * consume a REST web service
	 */
	public void run(String... strings) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://gturnquist-quoters.cfapps.io/api/random";
		Quote quote = restTemplate.getForObject(url, Quote.class);
		log.info(quote.toString());
	}

}