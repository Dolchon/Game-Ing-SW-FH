package Utility;

import java.io.IOException;

public class Utility {
	
	public static void clearScreen() {  
		try {
			Runtime.getRuntime().exec("clear");
			} catch (Exception e) {} 
	}
	
	
}