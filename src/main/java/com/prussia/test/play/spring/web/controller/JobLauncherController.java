package com.prussia.test.play.spring.web.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobLauncherController {

	@Autowired
	JobLauncher jobLauncher;

	// @Autowired
	// Job job;
	@Autowired
	Job processJob;
	//
	// @RequestMapping("/jobLauncher.html")
	// public void handle() throws Exception{
	// jobLauncher.run(job, new JobParameters());
	// }

	@RequestMapping(value = "/invokejob", method = RequestMethod.GET)
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(processJob, jobParameters);

		return "Batch job has been invoked";
	}
}
