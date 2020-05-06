package mathieu.pglp_9_9.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * gestion de la bdd.
 */
public abstract class Bdd {
    /**
     * obtenir la connection à la bdd.
     * @return connection à la bdd
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:derby:bdd9;create=false");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * créer la base de donnée.
     * @throws Exception erreur de création
     */
    public static void resetDataBase() throws Exception {
        Connection connect = DriverManager.getConnection(
                "jdbc:derby:bdd9;create=false");
        Bdd.delTables(connect);
        Bdd.initTableForme(connect);
        Bdd.initTableTriangle(connect);
        Bdd.initTableCarre(connect);
        initTableRectangle(connect);
        initTableCercle(connect);
        initTableGroupeForme(connect);
        initTableRelation(connect);
        connect.close();
    }
    /**
     * créer la bdd.
     * @throws SQLException erreur de création
     */
    public static void createDataBase()  {
        try {
            DriverManager.getConnection(
                "jdbc:derby:bdd9;create=true");
        } catch (SQLException e) {
           System.out.println("la base de donnée existe déjà");
        }
    }
    /**
     * supprime les tables.
     * @param connect connection a la bdd
     */
    private static void delTables(final Connection connect) {
        Statement stat = null;
        try {
            stat = connect.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stat.execute("drop table Composition");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table GroupeForme");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Cercle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Rectangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Carre");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Triangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table Forme");
        } catch (SQLException e) {
        }
    }
    /**
     * créer la table Forme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableForme(final Connection connect)
            throws SQLException {
        String table = "create table Forme ("
                + "variableName varchar(30) primary key"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table Triangle.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableTriangle(final Connection connect)
            throws SQLException {
        String table = "create table Triangle ("
                + "variableName varchar(30) primary key,"
                + "point1_x int,"
                + "point1_y int,"
                + "point2_x int,"
                + "point2_y int,"
                + "point3_x int,"
                + "point3_y int,"
                + "foreign key (variableName) references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table Carré.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableCarre(final Connection connect)
            throws SQLException {
        String table = "create table Carre ("
                + "variableName varchar(30) primary key,"
                + "topLeft_x int,"
                + "topLeft_y int,"
                + "longueur int,"
                + "foreign key (variableName) references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table Rectangle.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRectangle(final Connection connect)
            throws SQLException {
        String table = "create table Rectangle ("
                + "variableName varchar(30) primary key,"
                + "topLeft_x int,"
                + "topLeft_y int,"
                + "longueur int,"
                + "largeur int,"
                + "foreign key (variableName) references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table Cercle.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableCercle(final Connection connect)
            throws SQLException {
        String table = "create table Cercle ("
                + "variableName varchar(30) primary key,"
                + "centre_x int,"
                + "centre_y int,"
                + "rayon int,"
                + "foreign key (variableName) references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableGroupeForme(final Connection connect)
            throws SQLException {
        String table = "create table GroupeForme ("
                + "variableName varchar(30) primary key,"
                + "foreign key (variableName) references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelation(final Connection connect)
            throws SQLException {
        String table = "create table Composition ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idComposant) "
                + "references Forme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
}
