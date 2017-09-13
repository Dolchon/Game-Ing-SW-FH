package Main;

import Giocatore.Giocatore;

import Territorio.Lotto;
import Territorio.Territorio;
import Utility.*;


public class Main {
    
    private static char scelta;
    private static String messaggioDiUscita = "Grazie per aver giocato";
    private static char carattereDiUscita = 'Q';
    private static String messaggioDiBenvenuto = "Benvenuto Forestiero!\nQual e' il tuo nome?\nInserisci 3 caratteri\n";
    private static String raccoltaArma = "\nVuoi raccoglierel'arma? S/N \n";
    
    private static char opzione;
    private static String nome;
	public static void main(String[] args) {
		
		/*
		Lotto prova = new Lotto(10,2,true);
		System.out.println(prova.toString());
		*/
		nome = IO.leggiParola3(messaggioDiBenvenuto);
                
		Territorio prova = new Territorio();
		Giocatore player = new Giocatore(5,5,nome);
		
		prova.creaMappa();
		//prova.stampaMappa();
		
		//Utility.clearScreen();
		do{
                    prova.modificaMappa(player.getPosX(), player.getPosY(), player.getNome());
                    prova.stampaMappa(player.getPosX(), player.getPosY());
                    
                    if(player.getPosY() == prova.getxCitta() && player.getPosX() == prova.getyCitta()){
                        player.stampaStato();
                        Menu.menuCitta(); 
                    }else{
                        Lotto lotto = prova.getLotto(player.getPosX(), player.getPosY());
                        player.stampaStato();
                        lotto.stampaContenuto();
                        
                        if(!player.isEquipaggiato() && lotto.contieneArma()){
                            do{
                                System.out.println(raccoltaArma);
                                opzione = IO.leggiCarattere();
                            }while(opzione != 'S' && opzione != 'N');
                            if(opzione == 'S'){
                                player.setEquipaggiato(true);
                                lotto.svuotaLotto();
                            }
                        }
                        
                        
                        Menu.menu();
                    }
                    player.settaPosizione(scelta = IO.leggiCarattere());
                }while(scelta != carattereDiUscita);
                
                System.out.println(messaggioDiUscita);
                
	}

}
