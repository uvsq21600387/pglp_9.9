package mathieu.pglp_9_9.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Triangle;

public class DaoTriangleCRUD extends AbstractDao<Triangle>
implements Serializable {
    /**
     * serial number
     */
    private static final long serialVersionUID = -1720197546595327177L;
    /**
     * liste des triangles.
     */
    ArrayList<Triangle> list;
    /**
     * constructeur du Dao
     */
    public DaoTriangleCRUD() {
        list = new ArrayList<Triangle>();
    }
    @Override
    public Triangle create(final Triangle object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    @Override
    public Triangle find(final String id) {
        for (Triangle f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
    @Override
    public Triangle update(final Triangle object) {
        Triangle t = this.find(object.getVariableName());
        if(t == null) {
            return null;
        } else {
            list.remove(t);
            list.add(object);
            return object;
        }
    }
    @Override
    public void delete(final Triangle object) {
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
    public static DaoTriangleCRUD deserialize(final String path) {
        ObjectInputStream reader = null;
        DaoTriangleCRUD dp = null;
        try {
            FileInputStream file = new FileInputStream(path);
            reader = new ObjectInputStream(file);
            dp = (DaoTriangleCRUD) reader.readObject();
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
