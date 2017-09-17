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
public class LadroTest {
    
     /**
     * Test per verificare il corretto passaggio di forza e velocità
     */
    @Test
    public void testSatts() {
        
        Ladro player = new Ladro(1,1,"aaa");
        
        float expForza = (float) 0.5;
        float expVelocita = 2;
        
        assertEquals(expForza, player.getForza(), 0.001);
        assertEquals(expVelocita, player.getVelocita(), 0.001);
        
    }
    
    @Test
    /**
     * Test del danno in base alla forza
     */
     public void testCombattimento() {
        Ladro player1 = new Ladro(1,1,"aaa");
        Ladro player2 = new Ladro(1,1,"aaa");
        Ladro player3 = new Ladro(1,1,"aaa");
        Ladro player4 = new Ladro(1,1,"aaa");
        
        player1.setEquipaggiamento(1);//Spada
        player2.setEquipaggiamento(2);//Pugnale
        player3.setEquipaggiamento(3);//Arco
        
        int expResult1 = 80;
        int expResult2 = 70;
        int expResult3 = 60;
        int expResult4 = 20;
        
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
        
        Ladro player = new Ladro(1,1,"aaa");
        
        player.setXp(10);
        
        int expResult = 2;
        
        player.levelUp();
        
        assertEquals(expResult, player.getLivello());
        
    }
    
}
