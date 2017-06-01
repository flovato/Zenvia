package zenviatest;


public class NumerosRomanos {

	private static final String ALLOWEDLETTERS = "MDCLXVI";
	
	// Roman letters
	private static final String[] LETTERS = {
		"M", "D", "C", "L", "X", "V", "I"
	};

	// Respective value for each letter.
	private static final Integer VALUES[] = {
		1000, 500, 100, 50, 10, 5, 1, 0
	};

	/**
	 * Convert a Roman number to integer.
	 * @param {String} romanNumber  Roman number to be converted.
	 * @notes
	 *   Values greater than MMMCMXCIX (3999) are not supported.
	 *   
	 * @return Return a numeric value. Zero means invalid string.
	 */
	public static Integer decode(String romanNumber) {
		Integer result = 0;
		final String tmp = romanNumber.toUpperCase();
		Integer lastValue = 0;
		
		for (Integer i = tmp.length(); --i >= 0;) {
			final char letter = tmp.charAt(i);
			
			Integer idx = ALLOWEDLETTERS.indexOf(letter);
			if (idx == -1)
				return 0; // Found an invalid letter.
			
			final Integer letterValue = VALUES[idx];
			
			if (letterValue < lastValue)
				result -= letterValue;
			else
				result += letterValue;
			
			lastValue = letterValue; 
		}

		return result;
	}
	
	/**
	 * Convert an integer value to Roman number.
	 * @param {Integer} value  Numeric value to be encoded.
	 * @notes
	 *   Zero, negative values and zero are not supported.
	 *
	 * @return Return a string with the Roman number.
	 */
	public static String toString(final Integer value) {
		String result = "";
		Integer tmpValue = value;
		Boolean isHalf = false;

		// Values greater than 3999 are not supported.
		if (value >= 4000)
			return "";

		for (int i = 0; (i < LETTERS.length) && (tmpValue > 0); i++) {
			final String  letter = LETTERS[i];
			final Integer letterValue     = VALUES[i];
			final Integer nextletterValue = VALUES[i+1];

			if (tmpValue == letterValue) {
				result += letter;
				tmpValue -= letterValue;
			}
			else if (tmpValue > letterValue) {
				// Flags used for: 500, 50 and 5.
				if (isHalf) {
					if (tmpValue >= letterValue + (4 * nextletterValue)) {
						result += LETTERS[i+1] + LETTERS[i-1];

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
						result += letter + LETTERS[i-1];
					}
					else {
						while (--count >= 0)
							result += letter;
					}
					tmpValue = tmpValue % letterValue;
				}
			}
			
			isHalf = !isHalf;
		}

		return result;
	}
}
