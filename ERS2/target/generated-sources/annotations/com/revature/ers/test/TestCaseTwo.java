package com.revature.ers.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.revature.ers.services.LoginDao;

public class TestCaseTwo {
	
	@Test
	public void testGetEmployeeId() {
		int employeeId = LoginDao.getEmployeeId("mafifi");
		
		assertEquals(0, employeeId);
	}

}
