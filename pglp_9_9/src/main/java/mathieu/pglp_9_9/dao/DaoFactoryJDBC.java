package mathieu.pglp_9_9.dao;

import java.sql.Connection;

import mathieu.pglp_9_9.GroupeForme;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

public class DaoFactoryJDBC extends AbstractDaoFactory {

    private Connection connect;
    
    public DaoFactoryJDBC(Connection c) {
        connect = c;
    }
    
    @Override
    public AbstractDao<Cercle> getDaoCercle() {
        return new DaoCercleJDBC(connect);
    }

    @Override
    public AbstractDao<Carre> getDaoCarre() {
        return new DaoCarreJDBC(connect);
    }

    @Override
    public AbstractDao<Rectangle> getDaoRectangle() {
        return new DaoRectangleJDBC(connect);
    }

    @Override
    public AbstractDao<Triangle> getDaoTriangle() {
        return new DaoTriangleJDBC(connect);
    }

    @Override
    public AbstractDao<GroupeForme> getDaoGroupeForme() {
        return new DaoGroupeFormeJDBC(connect);
    }
}
