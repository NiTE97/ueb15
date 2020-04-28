import java.util.Scanner;

public class Dialog {
    //Scannerdeklaration
    private static Scanner input;

    //Funktionen
    private static final int TEILERSUMME = 1;
    private static final int CHECKSUMME = 2;
    private static final int NULLSTELLEN = 3;
    private static final int POTENZSUMME = 4;
    private static final int REIHENSUMME = 5;
    private static final int GGT = 6;

    private static final int REKURSIV = 1;
    private static final int ITERATIV = 2;
    private static final int MESSWERTE = 3;

    private static final int SELBST = 1;
    private static final int EINLESEN = 2;

    private static final int ENDE = 0;

    //Variablen zur Auswahl des Programms
    private static final int MATHFUNCTIONS = 1;
    private static final int PALINDROM = 2;
    private static final int PROGRAMMAUSWAHL = 9;

    //Fehlermeldungen und Ausgaben
    private static final String MSG_PROGRAMM_AUSWAHL = "Bitte wählen Sie einen der oben aufgelisteten Möglichkeiten aus!";
    private static final String MSG_FEHLER = "Ein Fehler wurde abgefangen";
    private static final String MSG_FILE_NOT_FOUND = "Datei wurde nicht gefunden!";

    private static final String MSG_UNGUELTIGER_TYP = "Ungültiger Typ";
    private static final String TRUE = "Eingabe hat den Test bestanden";
    private static final String FALSE = "Eingabe hat den Test nicht bestanden";




    public Dialog() {
        input = new Scanner(System.in);
    }

    private void start() {
        int funktion = -1;
        int programm = 0;
        boolean programmCheck = false;
        while (funktion != ENDE) {
            try {
                if (!programmCheck) {
                    programm = dialogListe();
                    programmCheck = true;
                }
                if (programm == MATHFUNCTIONS) {
                    funktion = mathFunctionsDialog();
                    ausfuehrenFunktion(funktion);
                } else if (programm == PALINDROM) {
                    funktion = palindromDialog();
                    palindromFunktion(funktion);
                } else {
                    System.out.println(MSG_PROGRAMM_AUSWAHL);
                    programm = dialogListe();
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println(MSG_UNGUELTIGER_TYP);
                input.next();

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());


            } catch (Exception e) {
                System.out.println(MSG_FEHLER + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Method dialogListe Fordert den Nutzer auf ein lager zu erstellen mit vorgegebener oder individueller Laenge
     */
    private int dialogListe() {
        int eingabe;
        System.out.print("Wollen Sie zu MathFunctions oder zu Palindrom?.\n\n" +
                MATHFUNCTIONS + ": MathFunctions" + "\n" +
                PALINDROM + ": Palindrom" + "\n" +
                "==> ");
        eingabe = input.nextInt();
        input.nextLine();
        if (eingabe == MATHFUNCTIONS) {
            return MATHFUNCTIONS;
        } else if (eingabe == PALINDROM) {
            return PALINDROM;
        } else{
            return -1;
        }
    }

    private int mathFunctionsDialog() {
        int eingabe;
        StringBuilder dialog = new StringBuilder();
        dialog.append("Was möchten Sie als nächstes machen?\n\n")
                .append(TEILERSUMME).append(": Teilersumme berechnen").append("\n")
                .append(CHECKSUMME).append(": Checksumme berechnen").append("\n")
                .append(NULLSTELLEN).append(": Nullstellen berechnen").append("\n")
                .append(POTENZSUMME).append(": Prüfen ob eine Zahl Summe von Potenzen ist").append("\n")
                .append(REIHENSUMME).append(": Reihensumme berechnen").append("\n")
                .append(GGT).append(": GGT ermitteln").append("\n")
                .append(PROGRAMMAUSWAHL).append(": Zur Programmauswahl zurückkehren").append("\n")
                .append(ENDE).append(": Programm beenden").append("\n");
        System.out.println(dialog);
        eingabe = input.nextInt();
        return eingabe;
    }

    private int palindromDialog() {
        int eingabe;
        StringBuilder dialog = new StringBuilder();
        dialog.append("Was möchten Sie als nächstes machen?\n\n")
                .append(REKURSIV).append(": Rekursiv auf Palindrom prüfen").append("\n")
                .append(ITERATIV).append(": Iterativ auf Palindrom prüfen").append("\n")
                .append(MESSWERTE).append(": Messwerte").append("\n")
                .append(PROGRAMMAUSWAHL).append(": Zur Programmauswahl zurückkehren").append("\n")
                .append(ENDE).append(": Programm beenden").append("\n");
        System.out.println(dialog);
        eingabe = input.nextInt();
        return eingabe;
    }

    private void ausfuehrenFunktion(int funktion) {
        switch (funktion) {
            case TEILERSUMME:
                System.out.println("Geben Sie die Zahl ein von der Sie die Teilersumme berechnen wollen: ");
                long zahl = input.nextLong();
                input.nextLine();
                System.out.println("Die Teilersumme von " + zahl + " ist: " + MathFunctions.berechneTeilersumme(zahl));
                break;
            case CHECKSUMME:
                System.out.println("Geben Sie die ISBN ein von der Sie die Checksumme berechnen wollen: ");
                long isbn = input.nextLong();
                input.nextLine();
                System.out.println("Die Checksumme von " + isbn + " ist: " + MathFunctions.berechneChecksummeIsbn(isbn));
                break;
            case NULLSTELLEN:
                System.out.println("Geben Sie die Werte ein fuer die Sie die Nullstellen berechnen wollen: ");
                System.out.println("Geben Sie die p ein: ");
                double p = input.nextDouble();
                input.nextLine();
                System.out.println("Geben Sie die q ein: ");
                double q = input.nextDouble();
                input.nextLine();
                System.out.println(MathFunctions.berechneNullstellen(p, q));
                break;
            case POTENZSUMME:
                System.out.println("Geben Sie die Zahl ein die Sie prüfen wollen: ");
                long n = input.nextLong();
                input.nextLine();
                if(MathFunctions.istSummeVonPotenzen(n)){
                    System.out.println(TRUE);
                }else{
                    System.out.println(FALSE);
                }
                break;
            case REIHENSUMME:
                System.out.println("Geben Sie n ein: ");
                int m = input.nextInt();
                input.nextLine();
                System.out.println("Geben Sie x ein: ");
                double x = input.nextDouble();
                input.nextLine();
                System.out.println("Das Ergebnis ist : " + MathFunctions.berechneReihensumme(m, x));
                break;
            case GGT:
                System.out.println("Geben Sie den ersten Wert ein: ");
                long a = input.nextLong();
                input.nextLine();
                System.out.println("Geben Sie den zweiten Wert ein: ");
                long b = input.nextLong();
                input.nextLine();
                System.out.println("Der groesste gemeinsame Teiler ist: " + MathFunctions.berechneGgt(a, b));
                break;
            case PROGRAMMAUSWAHL:
                start();
            case ENDE:
                System.out.println("Das Programm wird beendet!");
                break;
            default:
                System.out.println(MSG_PROGRAMM_AUSWAHL);
                break;
        }
    }

    private void palindromFunktion(int funktion) {
        switch (funktion) {
            case REKURSIV:
                int n;
                System.out.println("Wollen Sie die Zeichen selbst eingeben oder soll eine Datei ausgelesen werden?");
                System.out.println(SELBST + ": Selbst eingeben");
                System.out.println(EINLESEN + ": Datei einlesen");
                n = input.nextInt();
                input.nextLine();
                if(n == SELBST){
                    Palindrom p1 = new PalindromRekursiv();
                    String wort;
                    System.out.println("Geben Sie das zu prüfende Wort ein: ");
                    wort = input.nextLine();
                    if(p1.istPalindrom(wort)){
                        System.out.println(TRUE);
                    }else{
                        System.out.println(FALSE);
                    }
                }else if(n == EINLESEN){
                    Palindrom p1 = new PalindromRekursiv();
                    System.out.println("Geben Sie den Pfad der Datei ein: ");
                    String pfad = input.nextLine();
                    String wort = PalindromRekursiv.einlesen(pfad);
                    if(p1.istPalindrom(wort)){
                        System.out.println(TRUE);
                    }else if(wort.equals(MSG_FILE_NOT_FOUND)){
                        System.out.println(MSG_FILE_NOT_FOUND);
                    }else{
                        System.out.println(FALSE);
                    }
                }else{
                    System.out.println(MSG_PROGRAMM_AUSWAHL);
                }
                break;

            case ITERATIV:
            int m;
            System.out.println("Wollen Sie die Zeichen selbst eingeben oder soll eine Datei ausgelesen werden?");
            System.out.println(SELBST + ": Selbst eingeben");
            System.out.println(EINLESEN + ": Datei einlesen");
            m = input.nextInt();
            input.nextLine();
            if(m == SELBST){
                Palindrom p1 = new PalindromIterativ();
                String wort;
                System.out.println("Geben Sie das zu prüfende Wort ein: ");
                wort = input.nextLine();
                if(p1.istPalindrom(wort)){
                    System.out.println(TRUE);
                }else{
                    System.out.println(FALSE);
                }
            }else if(m == EINLESEN){
                Palindrom p1 = new PalindromIterativ();
                System.out.println("Geben Sie den Pfad der Datei ein: ");
                String pfad = input.nextLine();
                String wort = PalindromIterativ.einlesen(pfad);
                if(p1.istPalindrom(wort)){
                    System.out.println(TRUE);
                }else if(wort.equals(MSG_FILE_NOT_FOUND)){
                    System.out.println(MSG_FILE_NOT_FOUND);
                }else{
                    System.out.println(FALSE);
                }
            }else{
                System.out.println(MSG_PROGRAMM_AUSWAHL);
            }
            break;

            case MESSWERTE:
                PalindromSpeedTest.main(null);
                System.out.println("Ergebnisse werden in der Datei output.txt gespeichert");
                break;
            case PROGRAMMAUSWAHL:
                start();
            case ENDE:
                System.out.println("Das Programm wird beendet!");
                break;
            default:
                System.out.println(MSG_PROGRAMM_AUSWAHL);
                break;
        }
    }


    public static void main(String[] args) {
        new Dialog().start();
    }
}
