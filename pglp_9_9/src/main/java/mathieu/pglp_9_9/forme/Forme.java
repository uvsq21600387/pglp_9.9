package mathieu.pglp_9_9.forme;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * classe principale des formes.
 */
public abstract class Forme implements Serializable {
    /**
     * serial number.
     */
    private static final long serialVersionUID = -3210867423813860987L;
    /**
     * nom de variable.
     */
    protected String variableName;
    /**
     * obtenir le nom de variable de la forme.
     * @return le nom de variable de la forme
     */
    public String getVariableName() {
        return variableName + "";
    }
    /**
     * modifier le nom de variable de la forme.
     * @param newVariableName nouvelle valeur
     */
    public void setVariableName(final String newVariableName) {
        variableName = newVariableName + "";
    }
    /**
     * constructeur pour définir la variable.
     * @param nom_de_variable définir le nom de la variable de la forme
     */
    protected Forme(String nom_de_variable) {
        this.variableName = nom_de_variable;
    }
    /**
     * deplace une forme.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    public abstract void deplace(final int x, final int y);
    /**
     * affiche la forme.
     */
    public abstract void affiche();
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
}
