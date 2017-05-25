package Territorio;
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

    public void setForziereVuoto(boolean forziereVuoto) {
        this.forziereVuoto = forziereVuoto;
    }

    public void setPozione(boolean pozione) {
        this.pozione = pozione;
    }

    public void setPieno(boolean pieno) {
        this.pieno = pieno;
    }
	
}
