package net.codebattle;

/**
 * Represente le résultat d'une comparaison entre deux combinaisons
 * Le nombre de noirs est le nombre de pions bien places
 * Le nombre de blanc est le nombre de pions mal places
 */
public class Resultat {
    private int nbBienPlace, nbMalPlace;
    
    //Resultat gagnant. Tous les pions sont bien places.
    public static Resultat won = new Resultat(4,0);

    public Resultat(int bienPlace, int malPlace) {
        setNbBienPlace(bienPlace);
        setNbMalPlace(malPlace);
    }

    public int getNbMalPlace() {
        return nbMalPlace;
    }

    public void setNbMalPlace(int nbMalPlace) {
        this.nbMalPlace = nbMalPlace;
    }

    public int getNbBienPlace() {
        return nbBienPlace;
    }

    public void setNbBienPlace(int nbBienPlace) {
        this.nbBienPlace = nbBienPlace;
    }

    // Affichage du resultat de la comparaison
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return " Noir : " + getNbBienPlace() + " Blanc : " + getNbMalPlace();
    }

    // Comparaison de deux resultats
    // Deux resultats sont egaux si les nombres de blancs et de noirs sont egaux.
    public boolean equals(Object o) {
        if (o instanceof Resultat) {
            Resultat r = (Resultat) o;
            return (r.getNbBienPlace() == getNbBienPlace()) && (r.getNbMalPlace()==getNbMalPlace());
        }
        else
            return false;
    }
}
