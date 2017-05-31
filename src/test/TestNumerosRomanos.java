package zenviatest;

import org.junit.Assert;
import org.junit.Test;

public class TestNumerosRomanos {

	@Test
	public void testValidNumbers() {
		final Integer[] decValues = {
          1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
          11, 12, 13, 14, 15, 16, 17, 18, 19, 20
		};
		final String[] romanValues = {
			"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
			"XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"
		};

		for (int i = decValues.length; --i >= 0;) {
			Integer value = decValues[i];
			String  expectedResult = romanValues[i];
			
			Assert.assertEquals(NumerosRomanos.toString(value), expectedResult);
		}
	}
	
	@Test
	public void testNegativeNumbers() {
		final String romanNumber = NumerosRomanos.toString(-1);
		
		// Roman number does not support negative values.
		Assert.assertEquals(romanNumber, "");
	}

	@Test
	public void testZeroValue() {
		final String romanNumber = NumerosRomanos.toString(0);
		
		// There is not a Roman number for zero.
		Assert.assertEquals(romanNumber, "");
	}
	
	@Test 
	public void testMaxLimit() {
		final String romanNumber = NumerosRomanos.toString(4000);
		
		// Maximum Roman value is 3999.
		Assert.assertEquals(romanNumber, "");
	}
	
}