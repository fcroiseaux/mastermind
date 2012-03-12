package net.codebattle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale.
 * Represente une partie de Mastermind et permet de resoudre le jeu
 */
public class Mastermind {
    
	/**
	 * Classe Coup : un Essai + un Resultat correspondant pour une partie donnee
	 * 
	 */
	public static class Coup {
        public Essai essai;
        public Resultat resultat;
        public Coup(Essai e, Resultat r) {
            essai = e;
            resultat = r;
            System.out.println("Essai : " + e + "Result : " + r);
        }
    }
    
    /**
     * Permet de comparer deux essais
     * @param ess1
     * @param ess2
     * @return net.codebattle.Resultat : le resultat de la comparaison des deux essais.
     */
	public static Resultat compare(Essai ess1, Essai ess2) {
        int nbMalPlace = 0;
        int nbBienPlace = 0;

        for (int i =0; i< 4; i++)
            if (ess1.get(i).equals(ess2.get(i)))
            	// Si les memes couleurs sont au meme endroit, le pion est bien place. Un noir.
                nbBienPlace++;
            else if (ess2.getColors().contains(ess1.get(i)))
            	// Si la meme couleur est ailleurs dans le jeu, alors le pion est mal place, un blanc.
                    nbMalPlace++;

        return new Resultat(nbBienPlace, nbMalPlace);
    }
    
    private Essai solution;
    
    /**
     * Creation d'une nouvelle instance de jeu pour la solution sol.
     * @param sol
     */
    public Mastermind(Essai sol) {
        solution = sol;
    }

    /**
     * La liste des coups deja joues lors de cette partie
     */
    private List<Coup> coups = new ArrayList<Coup>();
    
    /**
     * Teste si l'essai e est eligigible comme essai gagnant
     * @param e
     * @return true si l'essai est elligible, false sinon.
     */
    private boolean match(Essai e) {
        for (Coup c : coups) {
          // Si il existe un coup parmi la liste des coups deja joues pour lequel
          // la comparaison avec l'essai teste ne donne pas le meme Resultat, alors l'essai n'est pas elligible
          if ( ! c.resultat.equals(compare(c.essai, e)))
              return false;
        }
        return true;
    }

    /**
     * Resolution du mastermind
     * On essaie tous les coups possibles un a un
     * Si un coup est elligible, on l'ajoute à la liste es coups joues et elligibles
     * Sinon, on passe au coup suivant
     * 
     * @return net.codebattle.Essai le resultat du jeu
     */
    public Essai resoud() {
        for (Color c1: Color.values())
            for (Color c2: Color.values())
                for (Color c3: Color.values())
                    for (Color c4: Color.values())   {
                        Essai e = new Essai(c1, c2, c3, c4);
                        Resultat r = compare(e, solution);
                        if (r.equals(Resultat.won)) {
                        	// C'est gagne, le resultat est trouve
                        	new Coup(e, r);
                            return e;
                        }
                        if (match(e))
                        	// Si le coup est eligible, on l'ajoute a la liste des coups deja joue
                        	// et on essaie le coup suivant
                            coups.add(new Coup(e,r));
                    }
        return null;
    }
}
