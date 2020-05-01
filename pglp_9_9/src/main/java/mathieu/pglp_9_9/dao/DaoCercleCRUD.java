package mathieu.pglp_9_9.dao;

import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Cercle;

public class DaoCercleCRUD extends AbstractDao<Cercle> {
    /**
     * liste des cercles.
     */
    ArrayList<Cercle> list;
    /**
     * constructeur du Dao
     */
    public DaoCercleCRUD() {
        list = new ArrayList<Cercle>();
    }
    @Override
    public Cercle create(final Cercle object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    @Override
    public Cercle find(final String id) {
        for (Cercle f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
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
    @Override
    public void delete(final Cercle object) {
        list.remove(object);
    }
}
