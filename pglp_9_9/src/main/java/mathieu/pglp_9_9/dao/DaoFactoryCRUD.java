package mathieu.pglp_9_9.dao;

import mathieu.pglp_9_9.GroupeForme;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

public class DaoFactoryCRUD extends AbstractDaoFactory {

    @Override
    public AbstractDao<Cercle> getDaoCercle() {
        return new DaoCercleCRUD();
    }

    @Override
    public AbstractDao<Carre> getDaoCarre() {
        return new DaoCarreCRUD();
    }

    @Override
    public AbstractDao<Rectangle> getDaoRectangle() {
        return new DaoRectangleCRUD();
    }

    @Override
    public AbstractDao<Triangle> getDaoTriangle() {
        return new DaoTriangleCRUD();
    }

    @Override
    public AbstractDao<GroupeForme> getDaoGroupeForme() {
        return new DaoGroupeFormeCRUD();
    }
}
