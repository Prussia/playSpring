package com.prussia.test.play.spring.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobCompletionListener extends JobExecutionListenerSupport {

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.warn("BATCH JOB jobExecution.getStatus() = {}", jobExecution.getStatus());
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.warn("BATCH JOB jobExecution.getStatus() = {}", jobExecution.getStatus());
	}

}
