package mathieu.pglp_9_9.forme;

import java.io.CharConversionException;

/**
 * classe pour une position en 2 dimensions.
 */
public class Position {
    /**
     * abscisse.
     */
    private int x;
    /**
     * ordonnée.
     */
    private int y;
    /**
     * constructeur de la classe en (0,0).
     */
    public Position() {
        x = 0;
        y = 0;
    }
    /**
     * constructeur de la classe avec x et y.
     * @param xValue valeur en abscisse
     * @param yValue valeur en ordonnée
     */
    public Position(final int xValue, final int yValue) {
        x = xValue;
        y = yValue;
    }
    /**
     * constructeur de position avec un type String.
     * syntaxe : (x,y)
     * @param position string contenant la position.
     * @throws CharConversionException invalid String
     */
    public Position(final String position) throws CharConversionException {
        position.replace(" ", "");
        if (position.charAt(0) != '('
        || position.charAt(position.length() - 1) != ')') {
            System.err.println(position);
            throw new CharConversionException();
        }
        String position2 = position.substring(1, position.length() - 1);
        String[] positionSplit = position2.split(",");
        if (positionSplit.length != 2) {
            System.err.println(position);
            throw new CharConversionException();
        }
        try {
            x = Integer.parseInt(positionSplit[0]);
            y = Integer.parseInt(positionSplit[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw e;
        }
    }
    /**
     * obtenir la valeur en abscisse.
     * @return valeur de x
     */
    public int getX() {
        return x;
    }
    /**
     * obtenir la valeur en ordonnée.
     * @return valeur de y
     */
    public int getY() {
        return y;
    }
    /**
     * déplace cette position selon les paramètres.
     * @param xValue décalage en abscisse par rapport à l'origine
     * @param yValue décalage en ordonnée par rapport à l'origine
     */
    public void deplace(final int xValue, final int yValue) {
        x += xValue;
        y += yValue;
    }
    /**
     * conversion en String d'une position.
     * @return position converti en chaine de caractère
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    /**
     * retourne une copie de la position.
     * @return copie de l'objet
     */
    @Override
    public Position clone() {
        return new Position(x, y);
    }
}
