package net.codebattle;

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 01/02/12
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class Resultat {
    private int nbBienPlace, nbMalPlace;
    
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

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return " Noir : " + getNbBienPlace() + " Blanc : " + getNbMalPlace();
    }


    public boolean equals(Object o) {
        if (o instanceof Resultat) {
            Resultat r = (Resultat) o;
            return (r.getNbBienPlace() == getNbBienPlace()) && (r.getNbMalPlace()==getNbMalPlace());
        }
        else
            return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
