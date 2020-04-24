import java.util.ArrayList;
import java.io.*;

/**
 * Klasse MathFunctions.
 * 
 * @author (Niklas Terwort && Tobias Steuer) 
 */
public class MathFunctions
{

    /**
     * Klassenkonstanten
     */
    private static final String NEGATIV = "Die eingegebene Zahl ist kleiner als 0!";
    private static final String NULL = "Die eingegebene Zahl darf nicht 0 sein!";
    private static final String ISBN_FALSCH = "Die ISBN ist nicht 9-stellig!";
    private static final long MIN_ISBN = 100000000;
    private static final long MAX_ISBN = 999999999;
    private static final double EPSILON = 1.0E-08;
    /**
     * Methode zum Berechnen der Teilersumme
     * param long zahl
     * 
     * return long teilersumme
     */
    public static long berechneTeilersumme(long zahl){
        Validator.check(zahl < 0, NEGATIV);
        long teilersumme = 0;
        for (int i = 1; i <= zahl/2; i++){
            if (zahl % i == 0){
                teilersumme += i;
            }
        }
        return teilersumme + zahl;
    }

    /**
     * Methode zum Berechnen der Checksumme der ISBN
     * param long isbn
     * 
     * return String checksumme
     */
    public static String berechneChecksummeIsbn(long isbn){
        Validator.check(isbn < MIN_ISBN || isbn > MAX_ISBN, ISBN_FALSCH);
        long checksumme = 0;
        int i = 9;
        String ausgabe = "Checksumme: ";
        while (isbn > 0){
            checksumme += (isbn % 10) * i;
            isbn = isbn / 10;
            i--;
        }
        if(checksumme % 11 == 10){
            return ausgabe + "X";
        } else{
            return ausgabe + checksumme % 11;
        }
    }

    /**
     * Methode zum Berechnen der Nullstellen
     * param double p
     * param double q
     * 
     * return String nullstellen
     */
    public static String berechneNullstellen(double p, double q){
        String nullstellen = "";
        double diskriminante, x, x1, x2;
        diskriminante = (p / 2) * (p / 2) -q;
        if (diskriminante >= EPSILON){
            x1 = -(p/2) + Math.sqrt(diskriminante);
            x2 = -(p/2) - Math.sqrt(diskriminante);
            nullstellen += "Zwei Nullstellen: " + x1 + " | " + x2;
        } else {
            if (diskriminante <= -EPSILON){
                nullstellen += "Die Funktion hat komplexe Nullstellen.";
            } else {
                x =  - (p/2);
                nullstellen += "Die Funktion hat eine doppelte Nullstelle bei " + x;
            }
        }
        return nullstellen;
    }

    /**
     * Methode zum Ueberpruefen, ob einer Zahl Summe aus Potenzen ist
     * param long n
     * 
     * return boolean istSummeVonPotenzen
     */
    public static boolean istSummeVonPotenzen(long n){
        Validator.check(n <= 0, NULL);
        for (int a = 1; (a*a*a*a)<= n; a++){
            for (int b = 1; (b*b*b) <= n; b++){
                for (int c = 1; (c*c) <= n; c++){
                    if (n == (a*a*a*a) + (b*b*b) + (c*c)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Methode zum Berechnen der Reihensumme
     * param int m
     * param double x
     *
     * (x-1)^n / nx^n
     *
     * return double ergebnis
     */
    public static double berechneReihensumme (int n, double x){
        double s = 0;
        Validator.check(n == 0 || x == 0, NULL);
        s = (Math.pow((x-1),n)) / (n * (Math.pow(x,n)));
        return s;
    }

    /**
     * Methode zum Berechnen des GGT nach Euklid rekursiv
     * param long a     Darf nicht negativ sein
     * param long b     Darf nicht negativ sein
     * 
     * ggT(a,0) = a
     * ggT(a,b) = ggT(b, a mod b)
     * 
     * return long ggt
     */
    public static long berechneGgt(long a, long b){
        Validator.check (a < 0 || b < 0, NEGATIV);
        if (a < b){
            long c = b;
            b = a;
            a = c;
        }
        if (b != 0){
            return berechneGgt(b, a % b);
        }
        else{
            return a;
        }
    }

    static class PalindromIterativ implements Palindrom
    {
        private static final String INPUT_ERR = "Die Eingabe darf nicht leer sein!";

        /**
         * Methode zum Einlesen einer Datei
         */
        @Override
        public String dateiEinlesen(){
            File datei = new File("input.txt");
            StringBuffer sb = new StringBuffer();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(datei)));
                String zeile;
                ArrayList <Character> buchstaben = new ArrayList <Character>();
                while ((zeile = reader.readLine()) != null){
                    for(int i = 0; i < zeile.length(); i++){
                        buchstaben.add(zeile.charAt(i)); 
                    }
                }
                for (char wort : buchstaben) {
                    sb.append(wort);
                }
                reader.close();
                return sb.toString();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return sb.toString();

        }

        /**
         * Methode zum Ueberpruefen ob das gegebene Wort ein Palindrom ist
         * param String Wort    Das zu pruefende Wort
         * 
         */
        @Override
        public boolean istPalindrom(String wort){  
            Validator.check (wort == null || wort.trim().isEmpty(), INPUT_ERR);
            wort = wort.toUpperCase();
            ArrayList <Character> buchstaben = new ArrayList <Character>();
            for ( int i = 0; i < wort.length(); i++){
                buchstaben.add(wort.charAt(i));   
            }
            for(int i = 0; i < buchstaben.size(); i++){
                for (int p = buchstaben.size() - 1; p >= i; p--){
                    return buchstaben.get(i).equals(buchstaben.get(p));
                }
            }
            return false; 
        }

        /**
         * Methode zum Messen wie lange die Methode braucht um ein Palindrom zu ueberpruefen
         */
        public long istPalindromCheckTime(String wort){
            long startTime = System.nanoTime();   
            istPalindrom(wort);
            long endTime = System.nanoTime();
            FileOutputStream out = null;
            try{
                out = new FileOutputStream("output.txt");
                out.write((int)(endTime - startTime));
            }catch(IOException e) {
                e.printStackTrace();
            }
            return endTime - startTime;
        }

        static class PalindromRekursiv implements Palindrom
        {
            /**
             * Methode zum Einlesen einer Datei
             */
            @Override
            public String dateiEinlesen(){
                File datei = new File("input.txt");
            StringBuffer sb = new StringBuffer();

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(datei)));
                String zeile;
                ArrayList <Character> buchstaben = new ArrayList <Character>();
                while ((zeile = reader.readLine()) != null){
                    for(int i = 0; i < zeile.length(); i++){
                        buchstaben.add(zeile.charAt(i)); 
                    }
                }
                for (char wort : buchstaben) {
                    sb.append(wort);
                }
                reader.close();
                return sb.toString();
            } catch(IOException e) {
                e.printStackTrace();
            }
            return sb.toString();

        }

            /**
             * Methode zum Ueberpruefen ob das gegebene Wort ein Palindrom ist
             * param String Wort    Das zu pruefende Wort
             * 
             */
            @Override
            public boolean istPalindrom(String wort){
                if(wort == null || wort.trim().isEmpty() || wort.length() == 1){
                    return true;
                }
                wort = wort.toUpperCase();
                ArrayList <Character> buchstaben = new ArrayList <Character>();
                for ( int i = 0; i < wort.length(); i++){
                    buchstaben.add(wort.charAt(i));   
                }
                if(buchstaben.get(0).equals(buchstaben.get(buchstaben.size()-1))){
                    return istPalindrom(wort.substring(1, wort.length()-1));
                }

                return false; 
            }

            /**
             * Methode zum Messen wie lange die Methode braucht um ein Palindrom zu ueberpruefen
             */
            public long istPalindromCheckTime(String wort){
                long startTime = System.nanoTime();   
                istPalindrom(wort);
                long endTime = System.nanoTime();
                return endTime - startTime;
            }
        }
    }
}
