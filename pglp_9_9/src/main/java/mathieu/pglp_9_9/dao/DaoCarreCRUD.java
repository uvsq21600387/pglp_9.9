package mathieu.pglp_9_9.dao;

import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Carre;

public class DaoCarreCRUD extends AbstractDao<Carre> {
    /**
     * liste des carrés.
     */
    ArrayList<Carre> list;
    /**
     * constructeur du Dao
     */
    public DaoCarreCRUD() {
        list = new ArrayList<Carre>();
    }
    @Override
    public Carre create(final Carre object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    @Override
    public Carre find(final String id) {
        for (Carre f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
    @Override
    public Carre update(final Carre object) {
        Carre t = this.find(object.getVariableName());
        if(t == null) {
            return null;
        } else {
            list.remove(t);
            list.add(object);
            return object;
        }
    }
    @Override
    public void delete(final Carre object) {
        list.remove(object);
    }
}
