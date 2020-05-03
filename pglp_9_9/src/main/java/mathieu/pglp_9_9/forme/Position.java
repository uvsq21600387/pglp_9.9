package mathieu.pglp_9_9.forme;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * classe pour une position en 2 dimensions.
 */
public class Position implements Serializable {
    /**
     * serial number.
     */
    private static final long serialVersionUID = 6970534443672751334L;
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
     * @param x valeur en abscisse
     * @param y valeur en ordonnée
     */
    public Position(final int x_value, final int y_value) {
        x = x_value;
        y = y_value;
    }
    /**
     * constructeur de position avec un type String.
     * syntaxe : (x,y)
     * @param position string contenant la position.
     */
    public Position(final String position) {
        if (position.charAt(0) != '(' || position.charAt(position.length() - 1) != ')') {
            //exception
        }
        String[] positionSplit = position.split(",");
        if (positionSplit.length != 2) {
            //exception
        }
        final int xP = x;
        final int yP = y;
        try {
            x = Integer.parseInt(positionSplit[0]);
            y = Integer.parseInt(positionSplit[1]);
        } catch (NumberFormatException e) {
            x = xP;
            y = yP;
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
     * @param x_value décalage en abscisse par rapport à l'origine
     * @param y_value décalage en ordonnée par rapport à l'origine
     */
    public void deplace(final int x_value, final int y_value) {
        x += x_value;
        y += y_value;
    }
    /**
     * conversion en String d'une position.
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
        return new Position(x,y);
    }
    /**
     * serialize vers le fichier voulu.
     * @param path nom du fichier vers lequel serializer
     */
    public void serialize(final String path) {
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(path);
            writer = new ObjectOutputStream(file);
            writer.writeObject(this);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println(
            "La serialization a échoué vers le fichier \""
            + path + "\"");
        }
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    /**
     * deserialize vers le fichier voulu.
     * @param path nom du fichier pour deserializer
     * @return l'instance de classe créé avec deserialization
     */
    public static Position deserialize(final String path) {
        ObjectInputStream reader = null;
        Position dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (Position) reader.readObject();
        } catch (IOException e) {
            System.err.println(
            "La deserialization a échoué depuis le fichier \""
            + path + "\"");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return dp;
    }
}
