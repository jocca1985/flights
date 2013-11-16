package com.main.flight.service;

import java.util.Date;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerImpl {

	private static final Logger logger = Logger.getLogger(SchedulerImpl.class);


	// Every night at 1 AM
	@Scheduled(cron = "* * 1 * * ?")
	public void generateRequest() {

		logger.info("Starting report at " + new Date(System.currentTimeMillis()));

		logger.info("Report sent at " + new Date(System.currentTimeMillis()));

	}

}
