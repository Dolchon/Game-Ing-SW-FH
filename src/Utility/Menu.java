package Utility;

//classe menu
public class Menu {
	
    private static String primaScelta = "Premi R per tornare in citta'";

    private static String secondaScelta = "Premi N per spostarti a Nord";
    private static String terzaScelta = "Premi S per spostarti a Sud";
    private static String quartaScelta = "Premi O per spostarti a Ovest";
    private static String quintaScelta = "Premi E per spostarti a Est";
    private static String sestaScelta = "Premi Q per uscire dal gioco";

    private static String messaggio1 = "\nEsegui una delle seguenti istruzioni:";

    public static void menu(){
        System.out.println(messaggio1);

        System.out.println(primaScelta);
        System.out.println(secondaScelta);
        System.out.println(terzaScelta);
        System.out.println(quartaScelta);
        System.out.println(quintaScelta);
        System.out.println(sestaScelta);
    }
    
    public static void menuCitta(){
        System.out.println(messaggio1);

        //System.out.println(primaScelta);
        System.out.println(secondaScelta);
        System.out.println(terzaScelta);
        System.out.println(quartaScelta);
        System.out.println(quintaScelta);
        System.out.println(sestaScelta);
    }
    
}
