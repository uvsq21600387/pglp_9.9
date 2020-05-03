package mathieu.pglp_9_9.dao;

import java.sql.Connection;

import mathieu.pglp_9_9.GroupeForme;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * pattern factory pour les Dao à opérations JDBC.
 */
public class DaoFactoryJDBC extends AbstractDaoFactory {
    /**
     * connection à la bdd.
     */
    private Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection à la bdd
     */
    public DaoFactoryJDBC(final Connection c) {
        connect = c;
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    @Override
    public AbstractDao<Cercle> getDaoCercle() {
        return new DaoCercleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    @Override
    public AbstractDao<Carre> getDaoCarre() {
        return new DaoCarreJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    @Override
    public AbstractDao<Rectangle> getDaoRectangle() {
        return new DaoRectangleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    @Override
    public AbstractDao<Triangle> getDaoTriangle() {
        return new DaoTriangleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    @Override
    public AbstractDao<GroupeForme> getDaoGroupeForme() {
        return new DaoGroupeFormeJDBC(connect);
    }
}
