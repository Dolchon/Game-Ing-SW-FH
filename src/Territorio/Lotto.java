package Territorio;

import Utility.Utility;

/**
 * 
 * @author Christian Fonga, Daniel Hanine
 * @version 1.0
 * 
 * Classe che rappresenta un singolo lotto.
 *
 */
public class Lotto {
	
	private int posX;
	private int posY;
	private boolean citta;
	private boolean presenzaGiocatore = false;
        private String nomePlayer;
        
        //attributi contenuto lotto
        private boolean spada = false;
        private boolean arco = false;
        private boolean pugnale = false;
        private boolean forzierePieno = false;
        private boolean forziereVuoto = false;
        private boolean pozione = false;
        private boolean pieno = false;
        private boolean orco = false;
        

	// Costruttore di Lotto
	public Lotto(int posX, int posY, boolean citta) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.citta = citta;
	}

	// Getter e setter di X e Y.
	
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

	// Metodo che setta la presenza del Giocatore nel Lotto.
	public void setPresenzaGiocatore(boolean cond, String nome){
			presenzaGiocatore = cond;
                        nomePlayer = nome;
	}
	
	// Metodo che stampa il contenuto del Lotto.
	public String toString(){
		
		String out = null;
		
		if(!citta && !presenzaGiocatore){
			//out = Integer.toString(posX) + ' ' + Integer.toString(posY);
                       out = "   ";
		}else if(citta){
			out = " S ";
		}else if(presenzaGiocatore){
			out = nomePlayer;
		}
		return out;
		
	}

    public boolean isOrco() {
        return orco;
    }

    public void setOrco(boolean orco) {
        this.orco = orco;
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

    public void setForzierePieno(boolean forzierePieno) {
        this.forzierePieno = forzierePieno;
    }
    
    public boolean getForzierePieno(){
        return forzierePieno;
    }

    public void setForziereVuoto(boolean forziereVuoto) {
        this.forziereVuoto = forziereVuoto;
    }

    public void setPozione(boolean pozione) {
        this.pozione = pozione;
    }
    
    public boolean getPozione(){
        return pozione;
    }

    public void setPieno(boolean pieno) {
        this.pieno = pieno;
    }
    
    public boolean isPieno(){
        return pieno;
    }
	
    //viene passato un intero e da questo con uno switch ne setto il contenuto del lotto
    public void setContenuto(int contenuto){
        
        switch (contenuto){
            case 0:
                setPieno(false);
                break;
            case 1:
                setSpada(true);
                setPieno(true);
                break;
            case 2:
                setArco(true);
                setPieno(true);
                break;
            case 3:
                setPugnale(true);
                setPieno(true);
                break;
            case 4:
                setArco(true);
                setPieno(true);
                break;
            case 5:
                setForzierePieno(true);
                setPieno(true);
                break; 
            case 6:
                setForzierePieno(true);
                setPieno(true);
                break; 
            case 7:
                setOrco(true);
                setPieno(true);
                break;
        }
    }
    
    public void svuotaLotto(){
        setPieno(false);
        setSpada(false);
        setArco(false);
        setPugnale(false);
        setPozione(false);
        setOrco(false);
    }
    
    public boolean contieneArma(){
        if(spada || arco || pugnale)
            return true;
        else 
            return false;
    }
    
    public void stampaContenuto(){
        String contenuto = "";
        
        if (!pieno)
            contenuto = "Il lotto è vuoto!";
        else if (spada)
            contenuto = "Il lotto continere una spada!";
        else if (arco)
            contenuto = "Il lotto contiene un arco!";
        else if (pugnale)
            contenuto = "Il lotto conetine un pugnale!";
        else if (pozione)
            contenuto = "Il lotto conetine una Pozione!";
        else if (forzierePieno)
            contenuto = "Il lotto conetine un forziere!";  
        else if (forziereVuoto)
            contenuto = "Il lotto conetine un forzierevuoto!";
        else if (orco)
            contenuto = "Attenzione! Un'Orco!";
        
        System.out.println(contenuto);
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
    
    public int randomForziere(){
        
        int casuale = Utility.random(5);
        if (casuale == 5)
            casuale = 4;
        return casuale;
    }
}
