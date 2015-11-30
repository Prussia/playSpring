package com.prussia.test.play.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAccountService implements AccountService {

	private RiskAssessor riskAssessor;

	@Autowired
	public DatabaseAccountService(RiskAssessor riskAssessor) {
		super();
		this.riskAssessor = riskAssessor;
	}
	
	public void setRiskAssessor(RiskAssessor riskAssessor) {
		this.riskAssessor = riskAssessor;
	}

	// ...

	public void createAcctount(String accountNo, String username) {
		riskAssessor.createAcctount(accountNo, username);
	}

}