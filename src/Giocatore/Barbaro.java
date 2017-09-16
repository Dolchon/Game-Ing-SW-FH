/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giocatore;

import static Utility.Utility.random50percento;
import static Utility.Utility.randomXpercento;

/**
 *
 * @author Hertz
 */
public class Barbaro extends Giocatore {
    
    private float forza;
    private float velocita;
    private int livello;
    
    public Barbaro(int _posX, int _posY, String _nome) {
        super(_posX, _posY, _nome);
        this.forza = (float) 2;
        this.velocita = (float) 0.5;
        this.livello = 1;
    }
    
    /**
     *
     */
     public void combatti(){
        
        if(!isEquipaggiato())
            healthPoint -= (int)(40/forza );
        else if(spada)
            healthPoint -= (int)(10/forza);
        else if(pugnale)
            healthPoint -= (int)(20/forza);
        else if(arco)
            healthPoint -= (int)(15/forza);
        xp +=1;
    }
    
    public int scappa(){
        velocita = velocita - (oro/100);
        return randomXpercento(25,velocita);
    }
     
     public void levelUp(){
         //System.out.println("ciao");
         if (xp %10 == 0){
             System.out.println("\n\tLevel UP\n");
             xp = 0;
             velocita += 0.2;
             forza += 0.2;
             livello += 1;
         }
     }
     
     public void stampaStato(){
        
        String giocatore;
        
        giocatore = "\nGiocatore: "+ nome +"\tPunti Vita: "+ healthPoint+"\tOro: "+oro+"\nFroza: "+forza+"\tXP: "+xp+"\tLivello: "+livello+"\n";
        
        System.out.println(giocatore);
    }
    
}
