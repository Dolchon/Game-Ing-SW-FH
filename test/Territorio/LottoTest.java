/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Territorio;

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
public class LottoTest {
    
    @Test
    /**
     * Test per controllare che il metodo set contenuto setti pieno il lotto
     */
    public void testSetContenuto(){
        
        Lotto test = new Lotto(1,1,false);
        Lotto test1 = new Lotto(1,1,false);
        
        test.setContenuto(1); //viene assegnata una spada a Lotto
        
        boolean expResult = true;
        boolean expResult1 = false;
        
        boolean result = test.isPieno();
        boolean result1 = test1.isPieno();
        
        assertEquals(expResult,result);
        assertEquals(expResult1,result1);
        
        
    }
    
    @Test
    /**
     * Test che controlla se il metodo svuota lotto funzioni correttamente
     */
    public void testSvuotaLotto(){
        Lotto test = new Lotto(1,1,false);
        
        test.setContenuto(1);
        test.svuotaLotto();
        
        boolean expResult = false;
        
        boolean result = test.isPieno();
        
        assertEquals(expResult,result);
        
    }
    
    @Test
    /**
     * Testa il corretto funzionamento del metodo toString in lotto
     */
    public void testToString(){
        Lotto lotto = new Lotto(1,1,false);
        Lotto citta = new Lotto(1,1,true);
        
        String expResultLotto = "   ";
        String expResultCitta = " S ";
        
        String resultLotto = lotto.toString();
        String resultCitta = citta.toString();
        
        assertEquals(expResultLotto,resultLotto);
        assertEquals(expResultCitta,resultCitta);
    }
}
