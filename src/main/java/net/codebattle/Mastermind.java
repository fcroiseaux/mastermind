package net.codebattle;

import java.awt.color.ColorSpace;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 01/02/12
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
public class Mastermind {
    
    public static class Coup {
        public Essai essai;
        public Resultat resultat;
        public Coup(Essai e, Resultat r) {
            essai = e;
            resultat = r;
            System.out.println("Essai : " + e + "Result : " + r);
        }
    }
    
    public static Resultat compare(Essai ess1, Essai ess2) {
        int nbMalPlace = 0;
        int nbBienPlace = 0;

        for (int i =0; i< 4; i++)
            if (ess1.get(i).equals(ess2.get(i)))
                nbBienPlace++;
            else if (ess2.getColors().contains(ess1.get(i)))
                    nbMalPlace++;

        return new Resultat(nbBienPlace, nbMalPlace);
    }
    
    private Essai solution;
    
    public Mastermind(Essai sol) {
        solution = sol;
    }

    private List<Coup> coups = new ArrayList<Coup>();
    
    private boolean match(Essai e) {
        for (Coup c : coups) {
          if ( ! c.resultat.equals(compare(c.essai, e)))
              return false;
        }
        return true;
    }

    public Essai resoud() {
        for (Color c1: Color.values())
            for (Color c2: Color.values())
                for (Color c3: Color.values())
                    for (Color c4: Color.values())   {
                        Essai e = new Essai(c1, c2, c3, c4);
                        Resultat r = compare(e, solution);
                        if (r.equals(Resultat.won)) {
                        	new Coup(e, r);
                            return e;
                        }
                        if (match(e))
                            coups.add(new Coup(e,r));
                    }
        return null;
    }
}
