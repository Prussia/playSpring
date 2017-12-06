package com.prussia.test.play.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.prussia.test.play.spring.batch.JobCompletionListener;
import com.prussia.test.play.spring.batch.Processor;
import com.prussia.test.play.spring.batch.Reader;
import com.prussia.test.play.spring.batch.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<String, String>chunk(1).reader(new Reader())
				.processor(new Processor()).writer(new Writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
	
	@Bean
	public TaskExecutor taskExecutor(){
	    SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor("spring_batch");
	    asyncTaskExecutor.setConcurrencyLimit(5);
	    return asyncTaskExecutor;
	}
	
	/*
	 * disable using the database to save metadata for its recover/retry functionality
	 */
	@Bean
	public PlatformTransactionManager getTransactionManager() {
	    return new ResourcelessTransactionManager();
	}

	@Bean
	public JobRepository getJobRepo() throws Exception {
	    return new MapJobRepositoryFactoryBean(getTransactionManager()).getObject();
	}
	
	
	
}
