package com.revature.ers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.revature.ers.services.LoginDao;

public class TestCaseOne {
	
	@Test
	public void testGetPositionByUsername() {
		String position = LoginDao.getPositionByUsername("mafifi");
		
		assertEquals("mgr", position);
	}
}
