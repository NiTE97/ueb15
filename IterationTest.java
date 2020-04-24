import java.util.ArrayList;
/**
 * Beschreiben Sie hier die Klasse IterationTest.
 * 
 * @author (Niklas Terwort && Tobias Steuer) 
 */
public class IterationTest
{
    public static void main (String [] args){
        ArrayList <String> buchstaben = new ArrayList <String>();
        String a = "aa";
        System.out.println("Messreihe bei Iteration");
        for (int i = 0; i < 25; i++){
            buchstaben.add(a); 
            PalindromIterativ p1 = new PalindromIterativ();
            StringBuffer sb = new StringBuffer();
            for (String wort : buchstaben) {
                sb.append(wort);
            }
            StringBuffer ausgabe = new StringBuffer();
            System.out.println("Anzahl der Buchstaben: " + buchstaben.size()*2 + "\t" + "Dauer der Methode: " +p1.istPalindromCheckTime(sb.toString()));
        }
    }
}
