
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Die Test-Klasse MathFunctionsTest.
 *
 * @author  (Niklas Terwort && Tobias Steuer)
 */

public class PalindromTest {

    @Test
    public void istPalindromRekursiv()
    {
        String wort = "Anna";
        PalindromRekursiv p1 = new PalindromRekursiv();
        assertTrue(p1.istPalindrom(wort));
    }

    @Test
    public void istPalindromRekursiv2()
    {
        String wort = "Rentner";
        PalindromRekursiv p1 = new PalindromRekursiv();
        assertTrue(p1.istPalindrom(wort));
    }

    @Test
    public void istPalindromIterativ()
    {
        String wort = "Anna";
        PalindromIterativ p1 = new PalindromIterativ();
        assertTrue(p1.istPalindrom(wort));
    }

    @Test
    public void istPalindromIterativ2()
    {
        String wort = "Rentner";
        PalindromIterativ p1 = new PalindromIterativ();
        assertTrue(p1.istPalindrom(wort));
    }

    @Test
    public void istPalindromRekursivFalse()
    {
        String wort = "Test";
        PalindromRekursiv p1 = new PalindromRekursiv();
        assertFalse(p1.istPalindrom(wort));
    }

    @Test
    public void istPalindromIterativFalse()
    {
        String wort = "Test";
        PalindromIterativ p1 = new PalindromIterativ();
        assertFalse(p1.istPalindrom(wort));
    }

    @Test (expected = IllegalArgumentException.class)
    public void istPalindromRekursivNull()
    {
        String wort = null;
        PalindromRekursiv p1 = new PalindromRekursiv();
        p1.istPalindrom(wort);
    }

    @Test (expected = IllegalArgumentException.class)
    public void istPalindromIterativNull()
    {
        String wort = null;
        PalindromIterativ p1 = new PalindromIterativ();
        p1.istPalindrom(wort);
    }

}
