package com.prussia.test.myspring;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.prussia.test.play.spring.service.DatabaseAccountService;
import com.prussia.test.play.spring.service.RiskAssessor;

public class TestDatabaseAccountService extends EasyMockSupport {

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	@Mock
	private RiskAssessor riskAssessor;

	@TestSubject
	private final DatabaseAccountService service = new DatabaseAccountService(riskAssessor);
	

	@Test
	public void testCreateAcctount() {
		riskAssessor.createAcctount("account11234", "Prussia");
		replayAll();
		service.createAcctount("account11234", "Prussia");
		verifyAll();

	}
}
