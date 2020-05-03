package mathieu.pglp_9_9.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Cercle;

/**
 * dao pour opération CRUD sur le Cercle.
 */
public class DaoCercleCRUD extends AbstractDao<Cercle>
implements Serializable {
    /**
     * serial number.
     */
    private static final long serialVersionUID = 2778967875684690724L;
    /**
     * liste des cercles.
     */
    ArrayList<Cercle> list;
    /**
     * constructeur du Dao.
     */
    public DaoCercleCRUD() {
        list = new ArrayList<Cercle>();
    }
    /**
     * ajoute un élément au DAO.
     * @param object l'élément à ajouter
     * @return la creation
     */
    @Override
    public Cercle create(final Cercle object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    /**
     * obtenir un élément par son identifiant.
     * @param id identifiant de l'élément à obtenir
     * @return l'élément souhaité
     */
    @Override
    public Cercle find(final String id) {
        for (Cercle f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    @Override
    public Cercle update(final Cercle object) {
        Cercle t = this.find(object.getVariableName());
        if(t == null) {
            return null;
        } else {
            list.remove(t);
            list.add(object);
            return object;
        }
    }
    /**
     * supprime un élément du DAO.
     * @param object élément à supprimer
     */
    @Override
    public void delete(final Cercle object) {
        list.remove(object);
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
    public static DaoCercleCRUD deserialize(final String path) {
        ObjectInputStream reader = null;
        DaoCercleCRUD dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (DaoCercleCRUD) reader.readObject();
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
