package net.codebattle;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: croiseaux
 * Date: 01/02/12
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public class Essai {

    private List<Color> colors = new ArrayList<Color>(4);
    
    public Essai(Color c1, Color c2, Color c3, Color c4) {
        colors.add(c1);
        colors.add(c2);
        colors.add(c3);
        colors.add(c4);
    }
    
    public List<Color> getColors() {
        return new ArrayList<Color>(colors);
    }
    
    public Color get(int i) {
        return colors.get(i);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	String s = "";
    	for (Color c : colors) {
    		s += c + " ";
    	}
    	return s;
    }

}
