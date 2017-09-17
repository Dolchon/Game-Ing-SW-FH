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
public class TerritorioTest {
    
    @Test
    /**
     * Test che controlla il funzionamento del metodo getLotto
     */
    public void testGetLotto() {
        Territorio field = new Territorio();
        field.creaMappa();
        
        assertNotNull(field.getLotto(1,1));
    }
}
