package com.prussia.test.play.spring;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.prussia.test.play.spring.dao.MyDao;
import com.prussia.test.play.spring.domain.Quote;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	MyDao mydao;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		printBeanDef(context);
		printMessageResources(context);
		
	}

	public static void printMessageResources(ApplicationContext context) {
		String message = context.getMessage("message.A", null, "default message", Locale.CHINA);
		log.info("message = " + message);
	}

	public void run(String... strings) throws Exception {
		// consumeREST();
		mydao.accessRelationDBbyTemplate();
	}

	/**
	 * consume a REST web service
	 */
	public void consumeREST() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://gturnquist-quoters.cfapps.io/api/random";
		Quote quote = restTemplate.getForObject(url, Quote.class);
		log.info(quote.toString());
	}

	private static void printBeanDef(ApplicationContext context) {
		int i = 0;
		for (String bean : context.getBeanDefinitionNames()) {
			i++;
			log.info(i + "." + bean);
		}

		int count = context.getBeanDefinitionCount();
		log.info("Total bean count: " + count);
	}

}