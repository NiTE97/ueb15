import java.io.*;
import java.util.ArrayList;

public class PalindromRekursiv implements Palindrom{

    private static final String INPUT_ERR = "Die Eingabe darf nicht leer sein!";
    private static final String FILE_ERR = "Die Datei wurde nicht gefunden!";


    @Override
    public boolean istPalindrom(String wort){
        Validator.check (wort == null || wort.trim().isEmpty(), INPUT_ERR);
        return rekursiv(wort);
    }

    private static boolean rekursiv(String wort){
        if (wort == null || wort.trim().isEmpty() || wort.length() == 1) {
            return true;
        }
        wort = wort.toUpperCase();
        if (wort.charAt(0) == wort.charAt(wort.length() - 1)) {
            return rekursiv(wort.substring(1, wort.length() - 1));
        }

        return false;
    }



    static String einlesen(String pfad) {
        File datei = new File(pfad);
        StringBuilder sb = new StringBuilder();
        if (!datei.exists()) {
            return "Datei wurde nicht gefunden!";
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(datei)));
            String zeile;
            ArrayList<Character> buchstaben = new ArrayList<>();
            while ((zeile = reader.readLine()) != null) {
                for (int i = 0; i < zeile.length(); i++) {
                    buchstaben.add(zeile.charAt(i));
                }
            }
            for (char wort : buchstaben) {
                sb.append(wort);
            }
            reader.close();
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
