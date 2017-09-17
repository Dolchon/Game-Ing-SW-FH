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
public class Paladino extends Giocatore {
    
    private float forza;
    private float velocita;
    private int livello;
    
    public Paladino(int _posX, int _posY, String _nome) {
        super(_posX, _posY, _nome);
        this.forza = 1;
        this.velocita = (float) 1;
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
        return randomXpercento(percentualebase,velocita);
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
        
        giocatore = "\nPaladino: "+ nome +"\tPunti Vita: "+ healthPoint+"\tOro: "+oro+"\nForza: "+forza+"\tXP: "+xp+"\tLivello: "+livello+"\n";
        
        System.out.println(giocatore);
    }
     
     public float getForza() {
        return forza;
    }

    public void setForza(float forza) {
        this.forza = forza;
    }

    public float getVelocita() {
        return velocita;
    }

    public void setVelocita(float velocita) {
        this.velocita = velocita;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }
    
}
