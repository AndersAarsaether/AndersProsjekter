package methods;

import java.util.Random;

public class Randomizer {

	private String inputString;
	private String splitRegex;
	
	public Randomizer(String inputString, String splitRegex) {
		
		this.inputString = inputString;
		this.splitRegex = splitRegex;
	}
	
	public String randomize() throws ArrayIndexOutOfBoundsException {
		
		String[] sTab = inputString.split(splitRegex);
		Random r = new Random();
		int count = sTab.length;
		
		int rValue = r.nextInt(count);
		
		return sTab[rValue];
	}
}
