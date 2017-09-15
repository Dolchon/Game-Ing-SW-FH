/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giocatore;

import static Utility.Utility.random50percento;

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
        this.velocita = (float) 0.5;
        this.livello = 1;
    }
    
    /**
     *
     */
     public void combatti(){
        
        if(!isEquipaggiato())
            healthPoint -= 40;
        else if(spada)
            healthPoint -= 10;
        else if(pugnale)
            healthPoint -= 20;
        else if(arco)
            healthPoint -= 15;
        xp +=1;
    }
    
     public int scappa(){
        return random50percento();
    }
     
     public void levelUp(){
         if (xp %10 == 0){
             xp = 0;
             velocita += 0.2;
             forza += 0.2;
         }
     }
     
     public void controllaVelocita(){
         velocita -= oro/100;
     }
}
