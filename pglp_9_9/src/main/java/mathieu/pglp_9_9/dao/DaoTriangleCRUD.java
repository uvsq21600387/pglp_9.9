package mathieu.pglp_9_9.dao;

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
}
