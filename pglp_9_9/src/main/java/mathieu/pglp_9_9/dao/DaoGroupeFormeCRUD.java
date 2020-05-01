package mathieu.pglp_9_9.dao;

import java.io.Serializable;
import java.util.ArrayList;

import mathieu.pglp_9_9.GroupeForme;

public class DaoGroupeFormeCRUD extends AbstractDao<GroupeForme>
implements Serializable {
    /**
     * serial number
     */
    private static final long serialVersionUID = 6125590853076054830L;
    /**
     * liste des groupeFormes.
     */
    ArrayList<GroupeForme> list;
    /**
     * constructeur du Dao
     */
    public DaoGroupeFormeCRUD() {
        list = new ArrayList<GroupeForme>();
    }
    @Override
    public GroupeForme create(final GroupeForme object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    @Override
    public GroupeForme find(final String id) {
        for (GroupeForme f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
    @Override
    public GroupeForme update(final GroupeForme object) {
        GroupeForme t = this.find(object.getVariableName());
        if(t == null) {
            return null;
        } else {
            list.remove(t);
            list.add(object);
            return object;
        }
    }
    @Override
    public void delete(final GroupeForme object) {
        list.remove(object);
    }
}
