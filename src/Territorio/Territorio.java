package Territorio;
import Utility.IO;
import java.util.ArrayList;

/**
 * 
 * @author Christian Fonga, Daniel Hanine
 * @version 1.0
 *
 */

public class Territorio {
	
    //Stringhe varie
    private String aCapo = "\n";
    private String separatore = " | ";
    private String TAB = "      ";

    // Dimensione territorio
    private int altezza;
    private int larghezza;

    private String nome;

    private ArrayList<Lotto> territorio;

    // Coordinate citta
    private static int xCitta;
    private static int yCitta;

    //Dimensioni default
    private final int altezzaDefault = 11;
    private final int larghezzaDefault = 11;
    private String nomeDefault = "BigCityLife";
    
    //Indici minimi mappa
    private int minX = 0;
    private int minY = 0;

    //costruttore
    public Territorio(int _altezza, int _larghezza, String _nome) {

        territorio = new ArrayList<Lotto>();

        this.altezza = _altezza;
        this.larghezza = _larghezza;
        this.nome = _nome;

    }

    //costruttore di default
    public Territorio() {

        territorio = new ArrayList<Lotto>();

        this.altezza = altezzaDefault;
        this.larghezza = larghezzaDefault;
        this.nome = nomeDefault;
    }

    // Metodo che crea la mappa
    public void creaMappa(){

        xCitta = larghezza / 2;
        yCitta = altezza / 2;

        for (int i = minX; i < larghezza; i++){//Y
            
            for (int j = minY; j < altezza; j++){//X
                
                //System.out.print(i +" "+ j+" | ");
                if(i != xCitta || j != yCitta){

                    Lotto quadrato = new Lotto(j, i, false);
                    territorio.add(quadrato);

                }else if(i == xCitta && j == yCitta){

                    Lotto quadrato = new Citta(j, i, true);

                    territorio.add(quadrato);
                }

            }
           // System.out.print("\n");
        }

    }

    // Metodo che stampa la mappa
    public void stampaMappa(int xGiocatore, int yGiocatore){
        
        int i = 0;
        int j = 0;
        int c = 0;
        int maxL;
        int maxY;
        
        System.out.print(TAB);
        for ( i = (xGiocatore - 5); i < (xGiocatore + 5); i++)
            System.out.print(IO.stampaPosFormattata(i));
        
        for ( i = (yGiocatore - 5); i < (yGiocatore + 5); i++){
            System.out.println(aCapo);
            for ( j = (xGiocatore - 5); j < (xGiocatore + 5); j++){
                
                if(c == 0)
                    System.out.print(IO.stampaPosFormattata(i));
                c++;
                System.out.print(getLotto(j,i).toString() + separatore);

            }
            c = 0;
        }
    }


    // Metodo che ritorna uno specifico Lotto.
    public Lotto getLotto(int x, int y){

        for(Lotto lotto : territorio){
            if(lotto.getPosX() == x && lotto.getPosY() == y)
                return lotto;
        }

            return null;
    }

    // Metodo che aggiorna la mappa.
    public void modificaMappa(int xGiocatore, int yGiocatore, String nome){

        aggiungiColonna(xGiocatore);
        aggiungiRiga(yGiocatore);
        
        for(Lotto lotto : territorio){
            if(lotto.getPosX() == xGiocatore && lotto.getPosY() == yGiocatore){
                lotto.setPresenzaGiocatore(true,nome);
            }else{
                lotto.setPresenzaGiocatore(false,null);
            }
        }

    }

    public static int getxCitta() {
        return xCitta;
    }

    public static int getyCitta() {
        return yCitta;
    }
	
    private void aggiungiColonna(int xGiocatore){
        
        //DX
        if(xGiocatore >= (altezza - 5)){
            System.out.println("Sono entrato nell'IF del DX");
            for(int i = minY; i < larghezza; i++){
                 Lotto quadrato = new Lotto(xGiocatore + 5, i, false);
                 territorio.add(quadrato);
            }
            altezza++;
        }
        
        //SX
        if(xGiocatore < (minX + 5)){
            for(int i = minY; i < larghezza; i++){
                 Lotto quadrato = new Lotto(xGiocatore - 5, i, false);
                 territorio.add(quadrato);
            }
            minX--;
            
        }
    }
    
     private void aggiungiRiga(int yGiocatore){
        
         //SUD
        if(yGiocatore >= (larghezza - 5)){
            for(int i = minX; i < altezza; i++){
                 Lotto quadrato = new Lotto(i, yGiocatore + 5, false);
                 territorio.add(quadrato);
            }
            larghezza++;
        }
        
        //NORD
        if(yGiocatore < (minY + 5)){
            for(int i = minX; i < altezza; i++){
                 Lotto quadrato = new Lotto(i, yGiocatore - 5, false);
                 territorio.add(quadrato);
            }
            minY--;
            
        }
    }
	

}
