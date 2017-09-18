/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Giocatore;

import Territorio.Territorio;
import static Utility.Utility.random50percento;

/**
 * 
 * @author ChristianFonga, Daniel Hanine
 * @version 1.0 
 * 
 * Classe che rappresenta un Giocatore
 */
//inizio
public class Giocatore {

    private int posX;
    private int posY;
    String nome;

    int healthPoint;
    int oro;
    int xp;
    int percentualebase;

    //equipaggiamento
    boolean spada = false;
    boolean arco = false;
    boolean pugnale = false;
    boolean equipaggiato = false;
    
    //private boolean pozione = false;

    //Stringhe per forziere
    private static String vuoto = "Il forziere trovato e' vuoto|";
    private static String oro10 = "Il forziere trovato contiene 10 monete";
    private static String oro20 = "Il forziere trovato contiene 20 monete";
    private static String oro30 = "Il forziere trovato contiene 30 monete";
    private static String veleno = "Il forziere trovato contiene veleno (-10HP)";

    //Costruttore di Giocatore
    public Giocatore(int _posX,int _posY, String _nome){

            this.posX = _posX;
            this.posY = _posY;
            this.nome = _nome;
            this.healthPoint = 100;
            this.oro = 0;
            this.xp = 1;
    }
    
    // Getter e Setter

    public boolean isEquipaggiato() {
        return equipaggiato;
    }

    public void setEquipaggiato(boolean cond) {
        equipaggiato = cond;
    }
    
    //metodo che setta equipaggiamento giocatore seguendo una codifica
    public void setEquipaggiamento(int equip){
        setEquipaggiato(true);
        switch (equip){
            case 1:
                setSpada(true);
                break;
            case 2:
                setArco(true);
                break;
            case 3:
                setPugnale(true);
                break;
        }
    }
    
    //metodo che svuota l'equipaggiamento del giocatore
    public void togliEquip(){
        setSpada(false);
        setArco(false);
        setPugnale(false);
        setEquipaggiato(false);
    }
    
    public int getPosX() {
            return posX;
    }

    public void setPosX(int posX) {
            this.posX = posX;
    }
    
    
    public int getPercentualebase() {
        return percentualebase;
    }

    public void setPercentualebase(int percentualebase) {
        this.percentualebase = percentualebase;
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
        this.healthPoint += healthPoint;
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
        
    public void beviPozione(){
        healthPoint += 10;
    }
    
    public void beviVeleno(){
        healthPoint -= 10;
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
    
    public void stampaStato(){
        
        String giocatore;
        
        giocatore = "\nGiocatore: "+ nome +"\nPunti Vita: "+ healthPoint+"\nOro: "+oro+"\n";
        
        System.out.println(giocatore);
    }
    
    public int getArma(){
        if (spada)
            return 1;
        else if (arco)
            return 2;
        else if(pugnale)
            return 3;
        else
            return 0;
    }
    
    public void getForziere(int opzione){
        switch (opzione){
            case 0:
                System.out.println(vuoto);
                break;
            case 1:
                System.out.println(oro10);
                oro += 10;
                break;
            case 2:
                System.out.println(oro20);
               oro += 20;
               break;
            case 3:
                System.out.println(oro30);
                oro +=30;
                break;
            case 4:
                System.out.println(veleno);
                beviVeleno();
                break;
        }
    }
    
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

    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void controllaVelocita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
    
    public boolean isVivo(){
        if(healthPoint > 0)
            return true;
        else
            return false;
    }
}
