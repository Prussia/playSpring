package com.prussia.test.myspring;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.prussia.test.play.spring.service.DatabaseAccountServiceBean;
import com.prussia.test.play.spring.service.RiskAssessorService;

public class TestDatabaseAccountService extends EasyMockSupport {

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	@Mock
	private RiskAssessorService riskAssessor;

	@TestSubject
	private final DatabaseAccountServiceBean service = new DatabaseAccountServiceBean(riskAssessor);
	

	@Test
	public void testCreateAcctount() {
		riskAssessor.createAcctount("account11234", "Prussia");
		replayAll();
		service.createAcctount("account11234", "Prussia");
		verifyAll();

	}
}
