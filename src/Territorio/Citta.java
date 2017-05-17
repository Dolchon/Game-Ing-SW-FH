/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Territorio;

/**
 *
 * @author Hertz
 */
public class Citta extends Lotto {
    
    private static int posX;
    private static int posY;

    public Citta(int posX, int posY, boolean citta) {
        super(posX, posY, citta);
    }

    
    public static int posY() {
        return  posY;//To change body of generated methods, choose Tools | Templates.
    }

   
    public static int posX() {
        return posX; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
