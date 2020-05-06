package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.SQLException;

import mathieu.pglp_9_9.bdd.Bdd;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * pattern factory pour les Dao à opérations JDBC.
 */
public class DaoFactoryJDBC {
    /**
     * connection à la bdd.
     */
    private Connection connect;
    /**
     * constructeur de la classe.
     */
    public DaoFactoryJDBC() {
        connect = Bdd.getConnection();
    }
    /**
     * ferme la connection.
     */
    public void close() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    public AbstractDao<Cercle> getDaoCercle() {
        return new DaoCercleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    public AbstractDao<Carre> getDaoCarre() {
        return new DaoCarreJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    public AbstractDao<Rectangle> getDaoRectangle() {
        return new DaoRectangleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    public AbstractDao<Triangle> getDaoTriangle() {
        return new DaoTriangleJDBC(connect);
    }
    /**
     * retourne le dao.
     * @return le dao
     */
    public AbstractDao<GroupeForme> getDaoGroupeForme() {
        return new DaoGroupeFormeJDBC(connect);
    }
}
