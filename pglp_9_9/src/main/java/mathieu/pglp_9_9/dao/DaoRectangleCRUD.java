package mathieu.pglp_9_9.dao;

import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Rectangle;

public class DaoRectangleCRUD extends AbstractDao<Rectangle> {
    /**
     * liste des rectangles.
     */
    ArrayList<Rectangle> list;
    /**
     * constructeur du Dao
     */
    public DaoRectangleCRUD() {
        list = new ArrayList<Rectangle>();
    }
    @Override
    public Rectangle create(final Rectangle object) {
        if(this.find(object.getVariableName()) != null) {
            return null;
        } else {
            list.add(object);
            return object;
        }
    }
    @Override
    public Rectangle find(final String id) {
        for (Rectangle f : list) {
            if(f.getVariableName().equals(id)) {
                return f;
            }
        }
        return null;
    }
    @Override
    public Rectangle update(final Rectangle object) {
        Rectangle t = this.find(object.getVariableName());
        if(t == null) {
            return null;
        } else {
            list.remove(t);
            list.add(object);
            return object;
        }
    }
    @Override
    public void delete(final Rectangle object) {
        list.remove(object);
    }
}
