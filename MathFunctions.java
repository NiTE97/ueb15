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
        for (int i = 1; i <= zahl; i++){
            if (zahl % i == 0){
                teilersumme += i;
            }
        }
        return teilersumme;
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
        Validator.check(n < 0, NEGATIV);
        for (long a = 0; (a*a*a*a)<= n; a++){
            for (long b = 0; (b*b*b) <= n; b++){
                for (long c = 0; (c*c) <= n; c++){
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
}
