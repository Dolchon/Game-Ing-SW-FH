/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giocatore;

import Territorio.Territorio;

/**
 * 
 * @author ChristianFonga, Daniel Hanine
 * @version 1.0 
 * 
 * Classe che rappresenta un Giocatore
 */

public class Giocatore {

    private int posX;
    private int posY;
    private String nome;

    private int healthPoint;
    private int oro;
    
    //equipaggiamento
    private boolean spada = false;
    private boolean arco = false;
    private boolean pugnale = false;
    
    //private boolean pozione = false;


    //Costruttore di Giocatore
    public Giocatore(int _posX,int _posY, String _nome){

            this.posX = _posX;
            this.posY = _posY;
            this.nome = _nome;
            this.healthPoint = 100;
            this.oro = 0;
    }

    // Getter e Setter
    public int getPosX() {
            return posX;
    }

    public void setPosX(int posX) {
            this.posX = posX;
    }

    public int getPosY() {
            return posY;
    }

    public void setPosY(int posY) {
            this.posY = posY;
    }

    public String getNome(){
        return nome;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setSpada(boolean spada) {
        this.spada = spada;
    }

    public void setArco(boolean arco) {
        this.arco = arco;
    }

    public void setPugnale(boolean pugnale) {
        this.pugnale = pugnale;
    }
        
        

    public void settaPosizione(char c){

        if(c == 'N')
            posY--;
        if(c == 'S')
            posY++;
        if(c == 'E')
            posX++;
        if(c == 'O')
            posX--;
        if(c == 'R'){
            posX = Territorio.getxCitta();
            posY = Territorio.getyCitta();

        }

    }
}
