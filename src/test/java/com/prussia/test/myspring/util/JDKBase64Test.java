package com.prussia.test.myspring.util;

import org.junit.Test;

import java.util.Base64;

import org.junit.Assert;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JDKBase64Test {

	@Test
	public void testBase64() {
		String enpassword = "V2FzYUBzc2cx";

		byte[] bpwd = Base64.getDecoder().decode(enpassword.getBytes());

		String password = new String(bpwd);
		log.warn("password: {}", password);

	}

	@Test
	public void testBase642() {
		String enpassword = "V2FzYUBzc2cxyz";

		byte[] bpwd = Base64.getDecoder().decode(enpassword.getBytes());

		String password = new String(bpwd);
		log.warn("password: {}", password);
	}
}
