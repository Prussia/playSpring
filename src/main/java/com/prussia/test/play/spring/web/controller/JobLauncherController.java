package com.prussia.test.play.spring.web.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Slf4j
public class JobLauncherController {

	@Autowired
	JobLauncher jobLauncher;

	// @Autowired
	// Job job;
	@Autowired
	Job processJob;
	 
	Map<String, JobExecution> jobExecutionMap = new ConcurrentHashMap<>();

	@RequestMapping(value = "/invokejob", method = RequestMethod.GET)
	public String startJob() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		JobExecution execution = jobLauncher.run(processJob, jobParameters);

		jobExecutionMap.put("exec-id", execution);

		return "Batch job has been invoked";
	}

	@RequestMapping(value = "/stopjob", method = RequestMethod.GET)
	public String stopJob() throws Exception {

		JobExecution jobExecution = jobExecutionMap.get("exec-id");
		log.warn("trying stop jobexecution: {}", jobExecution.getId());
		
		jobExecution.stop();
		
		log.warn("jobExecution.isStopping() = ", jobExecution.isStopping());
		boolean isStopped = false;
		if(jobExecution.isStopping()){
			isStopped = jobExecutionMap.remove("exec-id", jobExecution);
		}
		return "Stop Batch job return: " + isStopped;
	}
	
//	@RequestMapping(value = "/jobs/executions/{executionId}", method = RequestMethod.DELETE)
//	public String stop(@PathVariable long executionId) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
//		if (log.isDebugEnabled()) {
//			log.debug("Stop JobExecution with id: " + executionId);
//		}
//		Boolean successful = jobOperator.stop(executionId);
//		return successful.toString();
//	}

}
