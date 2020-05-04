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
        Bdd.initTableTriangle(connect);
        Bdd.initTableCarre(connect);
        initTableRectangle(connect);
        initTableCercle(connect);
        initTableRectangle(connect);
        initTableGroupeForme(connect);
        initTableRelationGG(connect);
        initTableRelationGCe(connect);
        initTableRelationGCa(connect);
        initTableRelationGR(connect);
        initTableRelationGT(connect);
    }
    /**
     * créer la bdd.
     * @throws SQLException erreur de création
     */
    public static void createDataBase() throws SQLException {
        DriverManager.getConnection(
                "jdbc:derby:bdd9;create=true");
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
            stat.execute("drop table CompositionTriangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table CompositionCercle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table CompositionCarre");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table CompositionRectangle");
        } catch (SQLException e) {
        }
        try {
            stat.execute("drop table CompositionGroupe");
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
                + "longueur int"
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
                + "largeur int"
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
                + "rayon int"
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
                + "variableName varchar(30) primary key"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelationGG(final Connection connect)
            throws SQLException {
        String table = "create table CompositionGroupe ("
                + "idGroupe varchar(30),"
                + "idGroupeComposant varchar(30),"
                + "primary key (idGroupe, idGroupeComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idGroupeComposant) "
                + "references GroupeForme (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelationGT(final Connection connect)
            throws SQLException {
        String table = "create table CompositionTriangle ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idGroupeComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idGroupeComposant) "
                + "references Triangle (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelationGCa(final Connection connect)
            throws SQLException {
        String table = "create table CompositionCarre ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idGroupeComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idGroupeComposant) "
                + "references Carre (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelationGR(final Connection connect)
            throws SQLException {
        String table = "create table CompositionRectangle ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idGroupeComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idGroupeComposant) "
                + "references Rectangle (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
    /**
     * créer la table de composition entre groupeForme et GroupeForme.
     * @param connect connexion a la bdd
     * @throws SQLException erreur sql
     */
    private static void initTableRelationGCe(final Connection connect)
            throws SQLException {
        String table = "create table CompositionCercle ("
                + "idGroupe varchar(30),"
                + "idComposant varchar(30),"
                + "primary key (idGroupe, idGroupeComposant),"
                + "foreign key (idGroupe) references "
                + "GroupeForme (variableName),"
                + "foreign key (idGroupeComposant) "
                + "references Cercle (variableName)"
                + ")";
        Statement stat = connect.createStatement();
        stat.execute(table);
    }
}
