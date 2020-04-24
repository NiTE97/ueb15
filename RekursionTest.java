import java.util.ArrayList;
/**
 * Klasse RekursionTest.
 * 
 * @author (Niklas Terwort && Tobias Steuer) 
 */
public class RekursionTest
{
    public static void main (String [] args){
        ArrayList <String> buchstaben = new ArrayList <String>();
        String a = "aa";
        System.out.println("Messreihe bei Rekursion");
        for (int i = 0; i < 25; i++){
            buchstaben.add(a); 
            PalindromRekursiv p1 = new PalindromRekursiv();
            StringBuffer sb = new StringBuffer();
            for (String wort : buchstaben) {
                sb.append(wort);
            }
            System.out.println("Anzahl der Buchstaben: " + buchstaben.size()*2 + "\t" + "Dauer der Methode: " +p1.istPalindromCheckTime(sb.toString()));
        }
    }
}
