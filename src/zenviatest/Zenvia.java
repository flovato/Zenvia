package zenviatest;

public class Zenvia {

	
	public static void main(String[] args) {
		Integer decValue = 3999;
		String romanNumber = NumerosRomanos.toString(decValue);
		
		System.out.print(decValue.toString() + " => " + romanNumber + "\n");
		System.out.print(romanNumber + " => " + NumerosRomanos.decode(romanNumber).toString());
	}
}
