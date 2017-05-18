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
	
}
