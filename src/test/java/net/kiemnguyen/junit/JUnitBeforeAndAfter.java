package net.kiemnguyen.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitBeforeAndAfter {
	static int additionSum = 4;
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class" + additionSum);
	}
	
	@Before
	public void beforeTest() {
		System.out.println("This is before test");
	}
	
	@Test
	public void this1Test() {
		System.out.println("This is 1 test");
	}
	
	@Before
	public void usingAssertTrue() {
		assertTrue("I know that 4 + 3 = ", (4+3)==7);
		System.out.println("AssertTrue");
	}
	
	@Test
	public void this2Test() {
		System.out.println("This is 2 test");
	}
	
	@Test
	public void this3Test() {
		System.out.println("This is 3 test");
	}
	
	@After
	public void afterTest() {
		System.out.println("This is after test");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
