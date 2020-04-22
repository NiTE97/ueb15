import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Die Test-Klasse MathFunctionsTest.
 *
 * @author  (Niklas Terwort && Tobias Steuer)
 */
public class MathFunctionsTest
{
    /**
     * Konstruktor fuer die Test-Klasse MathFunctionsTest
     */
    public MathFunctionsTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void berechneTeilersummeTest() {
        long zahl = 6;
        long expected = 12;
        long actual = MathFunctions.berechneTeilersumme(zahl);
        assertEquals(expected,actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void berechneTeilersummeNegativeZahlTest() {
        long zahl = -1;
        MathFunctions.berechneTeilersumme(zahl);
    }

    @Test
    public void berechneTeilersummeNullTest() {
        long zahl = 0;
        long expected = 0;
        long actual = MathFunctions.berechneTeilersumme(zahl);
        assertEquals(expected,actual);
    }

    @Test
    public void berechneChecksummeIsbnTest() {
        long isbn = 386680192;
        String expected = "Checksumme: 0";
        String actual = MathFunctions.berechneChecksummeIsbn(isbn);
        assertEquals(expected, actual);
    }

    @Test
    public void berechneChecksummeIsbnXTest() {
        long isbn = 473622066;
        String expected = "Checksumme: X";
        String actual = MathFunctions.berechneChecksummeIsbn(isbn);
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void berechneChecksummeIsbnZuKleinTest() {
        long isbn = 47362206;
        MathFunctions.berechneChecksummeIsbn(isbn);
    }

    @Test
    public void berechneNullstellenZweiNullstellenTest() {
        double p = 2.5;
        double q = 1.5;
        String expected = "Zwei Nullstellen: -1.0 | -1.5";
        String actual = MathFunctions.berechneNullstellen(p,q);
        assertEquals(expected, actual);
    }

    @Test
    public void berechneNullstellenDoppelteNullstelleTest() {
        double p = 3.0;
        double q = 2.25;
        String expected = "Die Funktion hat eine doppelte Nullstelle bei -1.5";
        String actual = MathFunctions.berechneNullstellen(p,q);
        assertEquals(expected, actual);
    }

    @Test
    public void berechneNullstellenKomplexeNullstellenTest() {
        double p = 1.5;
        double q = 2.5;
        String expected = "Die Funktion hat komplexe Nullstellen.";
        String actual = MathFunctions.berechneNullstellen(p,q);
        assertEquals(expected, actual);
    }

    @Test
    public void istSummeVonPotenzenTest() {
        long n = 3;
        assertTrue(MathFunctions.istSummeVonPotenzen(n));
    }

    @Test
    public void istSummeVonPotenzen2Test() {
        long n = 25;
        assertTrue(MathFunctions.istSummeVonPotenzen(n));
    }

    @Test
    public void istSummeVonPotenzen3Test() {
        long n = 11;
        assertTrue(MathFunctions.istSummeVonPotenzen(n));
    }

    @Test
    public void istSummeVonPotenzenNullTest() {
        long n = 0;
        assertTrue(MathFunctions.istSummeVonPotenzen(n));
    }

    @Test (expected = IllegalArgumentException.class)
    public void istSummeVonPotenzenNegativTest() {
        long n = -1;
        MathFunctions.istSummeVonPotenzen(n);
    }

    @Test
    public void berechneReihensummeTest() {
        int n = 1;
        double x = 1;
        double delta = 0.01;
        double expected = 0;
        double actual = MathFunctions.berechneReihensumme(n, x);
        assertEquals (expected, actual, delta);
    }
    @Test
    public void berechneReihensumme2Test() {
        int n = 1;
        double x = 2;
        double delta = 0.01;
        double expected = 0.5;
        double actual = MathFunctions.berechneReihensumme(n, x);
        assertEquals (expected, actual, delta);
    }
    @Test
    public void berechneReihensumme3Test() {
        int n = 2;
        double x = 3;
        double delta = 0.01;
        double expected = 0.222222;
        double actual = MathFunctions.berechneReihensumme(n, x);
        assertEquals (expected, actual, delta);
    }
}
