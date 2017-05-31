package zenviatest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestNumerosRomanos {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testValidNumbers() {
		NumerosRomanos n1 = new NumerosRomanos(9);
		NumerosRomanos n2 = new NumerosRomanos(4);
		NumerosRomanos n3 = new NumerosRomanos(5);
		
		
		Assert.assertEquals(n1.toString(), "IX");
		Assert.assertEquals(n2.toString(), "IV");
		Assert.assertEquals(n3.toString(), "V");
	}
	
	@Test
	public void testNegativeNumbers() {
		NumerosRomanos n = new NumerosRomanos(-1);
		
		
		Assert.assertEquals(n.toString(), "");
	}

	@Test
	public void testZeroValue() {
		NumerosRomanos n = new NumerosRomanos(0);
		
		
		Assert.assertEquals(n.toString(), "");
	}
	
}
