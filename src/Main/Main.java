package Main;

import Giocatore.Barbaro;
import Giocatore.Giocatore;
import Giocatore.Ladro;
import Giocatore.Paladino;

import Territorio.Lotto;
import Territorio.Territorio;
import Utility.*;

//Main
public class Main {
    
    private static char scelta;
    private static String messaggioDiUscita = "Grazie per aver giocato";
    private static char carattereDiUscita = 'Q';
    private static String messaggioDiBenvenuto = "Benvenuto Forestiero!\nQual e' il tuo nome?\nInserisci 3 caratteri\n";
    private static String raccoltaArma = "\nVuoi raccoglierel'arma? S/N ";
    private static String lasciaArma = "\nHai trovato uno spazio per depositare la tua arma! Vuoi lasciarla? S/N ";
    private static String pozione = "\nHai Trovato una pozione! Vuoi Berla? (+10HP) S/N ";
    private static String forziere = "\nIl lotto contiene un forziere, vuoi aprirlo? S/N";
    private static String orco = "\nVuoi combattere l'orco? S/N";
    private static String fugaFallita = "\nSpiacente non sei riuscito a scappare!";
    private static String fugaRiuscita = "\nSei riuscito a scappare!";
    private static String percentuale = "Aspetta!\nDimmi che percentuale di fuga vuoi utilizzare!";
    private static String morte = "I Tuoi hp sono a zero!\nLatua avventura termina qui!";
    private static String messaggiodiscelta = "Scegli la tua Classe!";
    
    private static char opzione;
    private static String nome;
	public static void main(String[] args) {
		
		/*
		Lotto prova = new Lotto(10,2,true);
		System.out.println(prova.toString());
		*/
		
		Territorio prova = new Territorio();
                
		Giocatore player = inizializzaGiocatore();
		
                setPercentuale(player);
                
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
                        
                        //metodo che aggiorno velocità ee livello del giocatore
                        aggiornaStatsGiocatore(player);
                        
                        //metodo che stampa le caratteristiche del giocatore
                        player.stampaStato();
                        
                        //metodo che stampa il contenuto del lotto
                        lotto.stampaContenuto();
                        
                        //se giocatore è equipaggiato e trova arma chiede se la si vuole lasciare a terra
                        equipaggiatoTrovaLottoVuoto(lotto,player);
                        
                        //if se player è senza equipaggiamento e trova un'arma
                        nonEquipaggiatoTrovaArma(lotto,player);
                        
                        //giocatore trova pozione
                        trovaPozione(lotto,player);
                        
                        //giocatore trova forziere pieno
                        trovaForzierePieno(lotto, player);
                        
                        //giocatore trova orco
                        trovaOrco(lotto, player);
                        
                        if(player.getHealthPoint() > 0)
                            Menu.menu();
                        else
                            System.out.println(morte);
                    }
                    if(player.getHealthPoint() > 0)
                        player.settaPosizione(scelta = IO.leggiCarattere());
                }while(scelta != carattereDiUscita && player.getHealthPoint() > 0);
                
                System.out.println(messaggioDiUscita);
                //fine
	}
        
        
        private static Giocatore inizializzaGiocatore(){
            nome = IO.leggiParola3(messaggioDiBenvenuto);
            Menu.sceltaClasse(nome);
            char op;
            do{
                System.out.println(messaggiodiscelta);
                op = IO.leggiCarattere();
            }while(op != 'P' && op != 'L' && op != 'B');
            
            Giocatore player;
            switch (op){
                case 'P':
                    player = new Paladino(5,5,nome);
                    return player;
                    
                case 'L':
                    player = new Ladro(5,5,nome);
                    return player;
                    
                case 'B':
                    player = new Barbaro(5,5,nome);
                    return player;
                   
            }
            return player = new Giocatore(5,5,nome);
        }
                
        private static void nonEquipaggiatoTrovaArma(Lotto lotto, Giocatore player){
            if(!player.isEquipaggiato() && lotto.contieneArma()){
                do{
                    System.out.println(raccoltaArma);
                    opzione = IO.leggiCarattere();
                }while(opzione != 'S' && opzione != 'N');

                if(opzione == 'S'){
                    //player.setEquipaggiato(true);
                    player.setEquipaggiamento(lotto.getArma());
                    lotto.svuotaLotto();
                }
            }
        }
        
        private static void equipaggiatoTrovaLottoVuoto(Lotto lotto, Giocatore player){
            if(player.isEquipaggiato() && !lotto.isPieno()){
                do{
                    System.out.println(lasciaArma);
                    opzione = IO.leggiCarattere();
                }while(opzione != 'S' && opzione != 'N');

                if(opzione == 'S'){
                    lotto.setContenuto(player.getArma());
                    player.togliEquip();
                }
            }
        }
        
        private static void trovaPozione(Lotto lotto, Giocatore player){
            if(lotto.getPozione()){
                do{
                    System.out.println(pozione);
                    opzione = IO.leggiCarattere();
                }while(opzione != 'S' && opzione != 'N');

                if(opzione == 'S'){
                    player.beviPozione();
                    lotto.svuotaLotto();
                }
            }
            
        }
        
        private static void trovaForzierePieno(Lotto lotto, Giocatore player){
            if(lotto.getForzierePieno()){
                do{
                    System.out.println(forziere);
                    opzione = IO.leggiCarattere();
                }while(opzione != 'S' && opzione != 'N');

                if(opzione == 'S'){
                    player.getForziere(lotto.randomForziere());
                    lotto.setForzierePieno(false);
                    lotto.setForziereVuoto(true);
                }
            }
            
        }
        
        private static void trovaOrco(Lotto lotto, Giocatore player){
            if(lotto.isOrco()){
                do{
                    System.out.println(orco);
                    opzione = IO.leggiCarattere();
                }while(opzione != 'S' && opzione != 'N');

                if(opzione == 'S'){
                    player.combatti();
                    lotto.svuotaLotto();
                }else{
                    if(player.scappa() == 0){                            
                        System.out.println(fugaFallita);
                        player.combatti();
                        lotto.svuotaLotto();
                    }else
                        System.out.println(fugaRiuscita);
                }
            }
        }
        
        private static void aggiornaStatsGiocatore(Giocatore player){
            player.levelUp();
            //player.controllaVelocita();
        }
        
        private static void setPercentuale(Giocatore player){
            System.out.println(percentuale);
            int percentualeInt;
            do{
                percentualeInt = IO.leggiNumero();
            }while(percentualeInt <0 && percentualeInt >100);
            player.setPercentualebase(percentualeInt);
        }
}
