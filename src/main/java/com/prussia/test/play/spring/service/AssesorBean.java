package com.prussia.test.play.spring.service;

import org.springframework.stereotype.Service;

@Service
public class AssesorBean implements RiskAssessorService {

	public AssesorBean(){
		super();
	}

	@Override
	public void createAcctount(String accountNo, String username) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
