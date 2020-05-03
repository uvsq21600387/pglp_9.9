package mathieu.pglp_9_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Forme;

/**
 * Pattern composite pour les formes.
 */
public class GroupeForme extends Forme implements Serializable {
    /**
     * serial number.
     */
    private static final long serialVersionUID = 311378715193261118L;
    /**
     * liste des formes.
     */
    private ArrayList<Forme> formes;
    /**
     * constructeur du groupe.
     * @param nom_de_variable nom de la variable pour le groupe
     */
    protected GroupeForme(String nom_de_variable) {
        super(nom_de_variable);
        formes = new ArrayList<Forme>();
    }
    /**
     * deplace les formes.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    @Override
    public void deplace(int x, int y) {
        for (Forme f : formes) {
            f.deplace(x, y);
        }
    }
    /**
     * affiche les formes et groupes de formes dans ce groupe.
     */
    @Override
    public void affiche() {
        System.out.println("Groupe (");
        for (Forme f : formes) {
            f.affiche();
        }
        System.out.println(")");
    }
    /**
     * ajoute une forme ou un groupe au groupe.
     * @param f forme ou groupe à ajouter au groupe
     */
    public void add(Forme f) {
        if (!formes.contains(f) && f != this) {
            formes.add(f);
        }
    }
    /**
     * supprime une forme ou un groupe du groupe.
     * @param f forme ou groupe à supprimer du groupe
     */
    public void remove(Forme f) {
        formes.remove(f);
    }
    /**
     * supprimer l'ensemble des formes et groupes du groupe.
     */
    public void reset() {
        while (!formes.isEmpty()) {
            formes.remove(0);
        }
    }
    /**
     * obtenir la liste des formes et groupes du groupe.
     * @return la liste des formes et groupe du groupe
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Forme> getList() {
        return (ArrayList<Forme>) formes.clone();
    }
    /**
     * deserialize vers le fichier voulu.
     * @param path nom du fichier pour deserializer
     * @return l'instance de classe créé avec deserialization
     */
    public static GroupeForme deserialize(final String path) {
        ObjectInputStream reader = null;
        GroupeForme dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (GroupeForme) reader.readObject();
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
