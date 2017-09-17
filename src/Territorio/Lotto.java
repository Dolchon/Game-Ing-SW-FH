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
        
        private static String vuotoMsg = "Il lotto e' vuoto!";
        private static String spadaMsg = "Il lotto contiene una spada!";
        private static String pugnaleMsg = "Il lotto contiene un pugnale!";
        private static String arcoMsg = "Il lotto contiene un'arco!";
        private static String pozioneMsg = "Il lotto contiene una pozione!";
        private static String forzierePienoMsg = "Il lotto contiene un forziere!";
        private static String forziereVuotoMsg = "Il lotto contiene un forziere vuoto!";
        private static String orcoMsg = "Attenzione un Orco!";
        

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
            contenuto = vuotoMsg;
        else if (spada)
            contenuto = spadaMsg;
        else if (arco)
            contenuto = arcoMsg;
        else if (pugnale)
            contenuto = pugnaleMsg;
        else if (pozione)
            contenuto = pozioneMsg;
        else if (forzierePieno)
            contenuto = forzierePienoMsg;  
        else if (forziereVuoto)
            contenuto = forziereVuotoMsg;
        else if (orco)
            contenuto = orcoMsg;
        
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
