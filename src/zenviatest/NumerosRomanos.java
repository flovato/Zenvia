package zenviatest;


public class NumerosRomanos {

	private static final String[] LETTERS = {
		"M", "D", "C", "L", "X", "V", "I"
	};
	
	private static final Integer VALUES[] = {
		1000, 500, 100, 50, 10, 5, 1, 0
	};
	
	private Integer value;
	
	public NumerosRomanos(Integer value) {
		this.value = value;
	}
/*
900 => DM
800 => DCCC
*/

//1001
	

	public String toString() {
		String result = "";
		Integer tmpValue = this.value;
		Boolean isHalf = false;
		
		for (int i = 0; (i < NumerosRomanos.LETTERS.length) && (tmpValue > 0); i++) {
			final String  letter = NumerosRomanos.LETTERS[i];
			final Integer letterValue     = NumerosRomanos.VALUES[i];
			final Integer nextletterValue = NumerosRomanos.VALUES[i+1];
			
			
			if (tmpValue == letterValue) {
				result += NumerosRomanos.LETTERS[i];
				tmpValue -= letterValue;
			}
			else if (tmpValue > letterValue) {
				if (isHalf) {
					if (tmpValue >= letterValue + (4 * nextletterValue)) {
						result += NumerosRomanos.LETTERS[i+1] + NumerosRomanos.LETTERS[i-1];
						
						tmpValue -= letterValue + (4 * nextletterValue); 
					}
					else {
						result += letter;
						tmpValue -= letterValue;
					}
				}
				else {
					Integer count = tmpValue / letterValue;
					if (count == 4) {
						result += letter + NumerosRomanos.LETTERS[i-1];
					}
					else {
						while (--count >= 0)
							result += letter;
					}
					tmpValue = tmpValue % letterValue;
				}
			}
			
			// Flags used for: 500, 50 and 5.
			isHalf = !isHalf;
		}

		return result;
	}
}
