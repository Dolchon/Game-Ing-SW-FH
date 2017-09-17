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
public class GiocatoreTest {
    
    /**
     * Testa che la funzione isEqipaggiato restituisca correttamente il valore
     */
    @Test
    public void testIsEquipaggiato() {
        
        Giocatore player = new Giocatore(1,1,"aaa");
        player.setEquipaggiato(true);
        boolean expResult = true;
        boolean result = player.isEquipaggiato();
        assertEquals(expResult, result);
    }
    
    /**
     * Test che controlla l'effettivo equipaggiamento del giocatore
     */
    @Test
    public void testArma() {
        
        Giocatore player1 = new Giocatore(1,1,"aaa");
        Giocatore player2 = new Giocatore(1,1,"aaa");
        Giocatore player3 = new Giocatore(1,1,"aaa");
        
        player1.setEquipaggiamento(1);
        player2.setEquipaggiamento(2);
        player3.setEquipaggiamento(3);

        boolean expResult = true;
        
        assertEquals(expResult, player1.isEquipaggiato());
        assertEquals(expResult, player2.isEquipaggiato());
        assertEquals(expResult, player3.isEquipaggiato());
        
    }
    
    /**
     * Test cheverifica la perdita di hp durante il combattimento
     */
    @Test
    public void testCombattimento() {
        Giocatore player1 = new Giocatore(1,1,"aaa");
        Giocatore player2 = new Giocatore(1,1,"aaa");
        Giocatore player3 = new Giocatore(1,1,"aaa");
        Giocatore player4 = new Giocatore(1,1,"aaa");
        
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
    
}
