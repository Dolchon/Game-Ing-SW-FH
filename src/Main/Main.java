package Main;

import Giocatore.Giocatore;

import Territorio.Lotto;
import Territorio.Territorio;
import Utility.*;


public class Main {
    
    private static char scelta;
    private static String messaggioDiUscita = "Grazie per aver giocato";
    private static char carattereDiUscita = 'Q';

	public static void main(String[] args) {
		
		/*
		Lotto prova = new Lotto(10,2,true);
		System.out.println(prova.toString());
		*/
		
		Territorio prova = new Territorio();
		Giocatore player = new Giocatore(5,5,"Pio");
		
		prova.creaMappa();
		//prova.stampaMappa();
		
		//Utility.clearScreen();
		do{
                    prova.modificaMappa(player.getPosX(), player.getPosY());
                    prova.stampaMappa(player.getPosX(), player.getPosY());
                    Menu.menu();
                    player.settaPosizione(scelta = IO.leggiCarattere());
                }while(scelta != carattereDiUscita);
                
                System.out.println(messaggioDiUscita);
                
	}

}
