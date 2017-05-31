package zenviatest;


public class NumerosRomanos {

	private static final String[] LETTERS = {
		"M", "D", "C", "L", "X", "V", "I"
	};
	
	private static final Integer VALUES[] = {
		1000, 500, 100, 50, 10, 5, 1
	};
	
	private Integer value;
	
	public NumerosRomanos(Integer value) {
		this.value = value;
	}
	
	
	public String toString() {
		String result = "";
		Integer tmpValue = this.value;
		
		
		for (int i = 0; (i < NumerosRomanos.LETTERS.length) && (tmpValue > 0); i++) {
			Integer count = tmpValue / NumerosRomanos.VALUES[i];
			
			if (count == 4) {
				result = result + NumerosRomanos.LETTERS[i+1] + NumerosRomanos.LETTERS[i];
			}
			else if (count <= 3) {
				while (count > 0)
					result = result + NumerosRomanos.LETTERS[i];
			}
			
			tmpValue = tmpValue % NumerosRomanos.VALUES[i];

			// This method is not working correctly yet.
			break; // FIXME: Added to avoid infinite loop.
		}

		return result;
	}
}
