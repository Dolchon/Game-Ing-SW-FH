/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giocatore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hertz
 */
public class PaladinoTest {
    
    /**
     * Test per verificare il corretto passaggio di forza e velocità
     */
    @Test
    public void testSatts() {
        
        Paladino player = new Paladino(1,1,"aaa");
        
        float expForza = (float) 1;
        float expVelocita = 1;
        
        assertEquals(expForza, player.getForza(), 0.001);
        assertEquals(expVelocita, player.getVelocita(), 0.001);
        
    }
    
    @Test
    /**
     * Test del danno in base alla forza
     */
     public void testCombattimento() {
        Paladino player1 = new Paladino(1,1,"aaa");
        Paladino player2 = new Paladino(1,1,"aaa");
        Paladino player3 = new Paladino(1,1,"aaa");
        Paladino player4 = new Paladino(1,1,"aaa");
        
        player1.setEquipaggiamento(1);//Spada
        player2.setEquipaggiamento(2);//Pugnale
        player3.setEquipaggiamento(3);//Arco
        
        int expResult1 = 90;
        int expResult2 = 85;
        int expResult3 = 80;
        int expResult4 = 60;
        
        player1.combatti();
        player2.combatti();
        player3.combatti();
        player4.combatti();
        
        assertEquals(expResult1, player1.getHealthPoint());
        assertEquals(expResult2, player2.getHealthPoint());
        assertEquals(expResult3, player3.getHealthPoint());
        assertEquals(expResult4, player4.getHealthPoint());
    }
    
     
      @Test 
    /**
     * test che controlla se il giocatore sale di livello
     */
    public void testLevelUP(){
        
        Paladino player = new Paladino(1,1,"aaa");
        
        player.setXp(10);
        
        int expResult = 2;
        
        player.levelUp();
        
        assertEquals(expResult, player.getLivello());
        
    }
}
