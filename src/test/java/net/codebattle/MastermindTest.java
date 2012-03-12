package net.codebattle;

import org.junit.*;
import static org.junit.Assert.*;
import static net.codebattle.Mastermind.*;
import static net.codebattle.Color.*;

/**
 * Unit test for simple Color.
 */
public class MastermindTest
{
    
    private Essai e(Color c1, Color c2, Color c3, Color c4) {
        return new Essai(c1, c2, c3, c4);
    }

    private Resultat r(int ok, int nOk) {
        return new Resultat(ok, nOk);
    }
    /**
     * Rigourous Test :-)
     */
    @Test
    public void test4Noirs()
    {
        assertTrue( compare(e(Bleu, Rouge, Vert, Brun), e(Bleu, Rouge, Vert, Brun)).equals(Resultat.won));
    }

    @Test
    public void test4Blancs()
    {

        assertTrue( compare(e(Bleu, Rouge, Vert, Brun), e(Rouge, Vert, Brun, Bleu)).equals(r(0,4)));

    }

    @Test
    public void test1N3B()
    {

        assertTrue( compare(e(Bleu, Bleu, Vert, Brun), e(Bleu, Bleu, Brun, Vert)).equals(r(2,2)));

    }
    
    @Test public void testWon() {
        Essai e1 = e(Jaune, Vert, Brun, Rouge);
        assertTrue(compare(e1, new Mastermind(e1).resoud()).equals(Resultat.won));
    }
}
