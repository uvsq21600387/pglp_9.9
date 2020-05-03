package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mathieu.pglp_9_9.GroupeForme;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * pattern de la fabrique.
 */
public abstract class AbstractDaoFactory {
    /**
     * type de fabrique possible.
     */
    public enum DaoType {
        /**
         * crud version.
         */
        CRUD,
        /**
         * jdbc version.
         */
        JDBC;
    }
    
    public abstract AbstractDao<Cercle> getDaoCercle();
    public abstract AbstractDao<Carre> getDaoCarre();
    public abstract AbstractDao<Rectangle> getDaoRectangle();
    public abstract AbstractDao<Triangle> getDaoTriangle();
    public abstract AbstractDao<GroupeForme> getDaoGroupeForme();
    
    /**
     * récupérer une fabrique.
     * @param t type de fabrique souhaité
     * @return la fabrique, null sinon
     */
    public static AbstractDaoFactory getFactory(final DaoType t) {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(
                    "jdbc:derby:bdd9;create=false");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        switch (t) {
        case CRUD :
            return new DaoFactoryCRUD();
        case JDBC :
            return new DaoFactoryJDBC(connect);
        default :
            return null;
        }
    }
}
