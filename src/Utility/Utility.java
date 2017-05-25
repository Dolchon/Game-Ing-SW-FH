package Utility;

import java.io.IOException;
import java.util.*;

public class Utility {
	
    public static void clearScreen() {  
            try {
                    Runtime.getRuntime().exec("clear");
                    } catch (Exception e) {} 
    }
	
    //utilizza la classe  java.util.Random per generare un randoma tra 0 e range
    public static int random(int range){
        Random random = new Random();
        return random.nextInt(range);
    }
}