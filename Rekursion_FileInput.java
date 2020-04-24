
/**
 * Beschreiben Sie hier die Klasse Rekursion_FileInput.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Rekursion_FileInput
{
    public static void main (String [] args){
       MathFunctions.PalindromIterativ.PalindromRekursiv p1 = new MathFunctions.PalindromIterativ.PalindromRekursiv();
       String wort = p1.dateiEinlesen();
       System.out.println(p1.istPalindrom(wort));
    }
}
