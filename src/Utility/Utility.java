package Utility;

import java.io.IOException;
import java.util.*;

public class Utility {
	
    private final static Random random = new Random();
    
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
    
    //ritorna o 1 o 2
    public static int random50percento(){
        if (random.nextBoolean()) {
            return 1;
        } else {
             return 2;
        }
    }
    
    public static int randomXpercento(int base, float velocita){
        
        int[] array = new int[100];
        int percentuale = (int) (base * velocita);
        //System.out.println(percentuale);
        for (int i=0; i<100; i++){
            if(i<percentuale)
                array[i] = 1;
            else
                array[i] = 0;
        }
        
        return array[random(99)];
        
    }
    
}