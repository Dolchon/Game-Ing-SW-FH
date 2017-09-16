package Utility;

import java.util.Scanner;

/**
 * Classe di utilita.
 * 
 * 
 * @author Christian Fonga, Daniel Hanine
 * @version 1.0
 * 
 */

public class IO 
{
	
	private static final String ERRORE_3_LETTERE = "Attenzione, il nome deve essere di 3 lettere!";
	private static final String ERRORE_UN_CARATTERE = "Attenzione, inserire solo un carattere!";
	private static final String SPAZIO = " ";
	
	// Creazione di uno scanner per l'input.
	private static Scanner lettore = creaScanner();
	
	/**
	 * Metodo che crea uno scanner.
	 * 
	 * @return s Scanner creato.
	 */
	private static Scanner creaScanner()
	{
		Scanner s = new Scanner(System.in);
		
		return s;
	}
	
	/**
	 * Metodo che pulisce il buffer.
	 */
	private static void pulisciLinea()
	{
		//serve per rimuovere cio' che resta dopo la lettura di qualcosa da tastiera, ad esempio l'invio dopo la lettura di un int
		lettore.nextLine();
	}
	
	/**
	 * Metodo per leggere la prima stringa introdotta da tastiera.
	 * La lettura si interrompe alla ricezione del carattere "Invio".
	 * 
	 * @return letta La parola letta
	 */
	public static String leggiParola()
	{
		String letta = lettore.next();
		
		// dopo la lettura della parola si pulisce la linea per eliminare eventuali invii rimasti nel buffer.
		pulisciLinea();
		
		return letta;
	}
	
	/**
	 * Metodo che legge la prima stringa introdotta da tastiera stampando prima a video il messaggio passato come parametro.
	 * 
	 * @param messaggio Messaggio da prensentare prima della lettura della parola
	 * @return la parola letta
	 */
	public static String leggiParola(String messaggio)
	{
		System.out.print(messaggio);
		return leggiParola();
	}
	
	/**
	 * Metodo che legge una parola non vuota da tastiera.
	 * 
	 * @param messaggio Messaggio da prensentare prima della lettura della parola
	 * @return la parola non vuota letta
	 */
	public static String leggiParola3(String messaggio)
	{
		
		String letta  = leggiParola(messaggio);

		while(letta.length() != 3)
		{
			System.out.println(ERRORE_3_LETTERE);
			letta = leggiParola(messaggio);
		}
		return letta;
	}
	
	public static char leggiCarattere(){
		
		String carattere = leggiParola().toUpperCase();
		while(carattere.length() != 1){
			System.out.println(ERRORE_UN_CARATTERE);
			carattere = leggiParola().toUpperCase();
	
		}
		return carattere.charAt(0);
	}
	
        public static int leggiNumero(){
		
		String carattere = leggiParola().toUpperCase();
		
                int n = Integer.parseInt(carattere);
		return n;
	}
        
        /**
	 * Metodo che stampa la posizione attorno alla griglia formattata.
	 * @param pos
	 * @return
	 */
	public static String stampaPosFormattata(int pos){
		
            String out;

            if(pos>= 0 && pos <= 9){

                out = (SPAZIO + SPAZIO + pos + SPAZIO + SPAZIO + SPAZIO);

            }else if(pos > 9 && pos <= 99 ){

                out = (SPAZIO + SPAZIO + pos + SPAZIO + SPAZIO);

            }else if(pos > 99 && pos <= 999 ){

                out = (SPAZIO + pos + SPAZIO + SPAZIO);

            }else if(pos < 0 && pos >=-9){

                out = (SPAZIO + SPAZIO + pos + SPAZIO + SPAZIO);

            }else if(pos <-9 && pos >=-99){

                out = (SPAZIO + pos + SPAZIO + SPAZIO);

            }else if(pos <-99 && pos >=-999){

                out = (SPAZIO + pos + SPAZIO);

            }else 

                out = SPAZIO + "Over" + SPAZIO;

            return out;
	}
		
	
}

