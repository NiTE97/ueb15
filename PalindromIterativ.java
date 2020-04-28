import java.io.*;
import java.util.ArrayList;

public class PalindromIterativ implements Palindrom{
    private static final String INPUT_ERR = "Die Eingabe darf nicht leer sein!";

    @Override
    public boolean istPalindrom(String wort){
        Validator.check (wort == null || wort.trim().isEmpty(), INPUT_ERR);
        int start = 0;
        int end = wort.length() -1;

        while (start < end) {
            char first = Character.toLowerCase(wort.charAt(start));
            char last = Character.toLowerCase(wort.charAt(end));

            if (Character.isLetter(first) && Character.isLetter(last)) {
                if (first == last) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            if (!Character.isLetter(last)) {
                end--;
            }
            if (!Character.isLetter(first)) {
                start++;
            }
        }
        return true;
    }



    public static String einlesen(String pfad) {
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
