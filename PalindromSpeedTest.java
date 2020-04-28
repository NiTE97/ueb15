import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse IterationTest.
 * 
 * @author (Niklas Terwort && Tobias Steuer) 
 */
public class PalindromSpeedTest
{
    public static void main (String [] args){
        tests();
    }

    static void tests() {
        BufferedWriter output = null;
        File file = new File("output.txt");
        ArrayList<String> buchstaben1 = new ArrayList<>();
        ArrayList<String> buchstaben2 = new ArrayList<>();

        String a = "aa";

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            output = new BufferedWriter(new FileWriter(file));
            output.write("Rekursionstests: ");
            StringBuffer sb;
            for (int i = 0; i < 25; i++) {
                buchstaben1.add(a);
                sb = new StringBuffer();
                for (String wort : buchstaben1) {
                    sb.append(wort);
                }
                output.write(istPalindromCheckTimeRekursiv(sb.toString()) + ", ");
            }

            output.write("\nIterationstests: ");
            for (int i = 0; i < 25; i++) {
                buchstaben2.add(a);
                sb = new StringBuffer();
                for (String wort : buchstaben2) {
                    sb.append(wort);
                }
                output.write(istPalindromCheckTimeIterativ(sb.toString()) + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert output != null;
                output.flush();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Methode zum Messen wie lange die Methode braucht um ein Palindrom zu ueberpruefen
     */
    static long istPalindromCheckTimeRekursiv(String wort) {
        Palindrom p1 = new PalindromRekursiv();
        long startTime = System.nanoTime();
        p1.istPalindrom(wort);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    static long istPalindromCheckTimeIterativ(String wort) {
        Palindrom p1 = new PalindromIterativ();
        long startTime = System.nanoTime();
        p1.istPalindrom(wort);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}
