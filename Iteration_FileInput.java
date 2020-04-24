
/**
 * Beschreiben Sie hier die Klasse Iteration_FileInput.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Iteration_FileInput
{
   public static void main (String [] args){
       MathFunctions.PalindromIterativ p1 = new MathFunctions.PalindromIterativ();
       String wort = p1.dateiEinlesen();
       System.out.println(p1.istPalindrom(wort));
    }
}
