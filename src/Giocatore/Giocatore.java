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
	
	//Costruttore di Giocatore
	public Giocatore(int _posX,int _posY, String _nome){
		
		this.posX = _posX;
		this.posY = _posY;
		this.nome = _nome;
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
