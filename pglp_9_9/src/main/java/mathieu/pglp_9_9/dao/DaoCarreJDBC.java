package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Position;

/**
 * dao pour opération JDBC sur le Carré.
 */
public class DaoCarreJDBC extends AbstractDao<Carre> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoCarreJDBC(final Connection c) {
        connect = c;
    }
    /**
     * supprime toutes les associations
     * de la forme contenu dans les groupes.
     * @param id identifiant de la forme
     */
    private void deleteComposant(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Composition WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * ajoute un élément au DAO.
     * @param object l'élément à ajouter
     * @return la creation
     */
    @Override
    public Carre create(final Carre object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Forme"
                    + " (variableName)"
                    + " VALUES(?)");
                    prepare.setString(un, object.getVariableName());
                    prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO Carre"
                    + " (variableName,topLeft_x,topLeft_y,longueur)"
                    + " VALUES(?, ?, ?, ?)");
            prepare.setString(un, object.getVariableName());
            prepare.setInt(deux, object.getTopLeft().getX());
            prepare.setInt(trois, object.getTopLeft().getY());
            prepare.setInt(quatre, object.getLongueur());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }
    /**
     * obtenir un élément par son identifiant.
     * @param id identifiant de l'élément à obtenir
     * @return l'élément souhaité
     */
    @Override
    public Carre find(final String id) {
        final int un = 1;
        Carre find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Carre WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position p = new Position(result.getInt("topLeft_x"),
                        result.getInt("topLeft_y"));
                find = new Carre(id, p, result.getInt("longueur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }
    /**
     * obtenir tous les éléments.
     * @return tous les éléments
     */
    @Override
    public ArrayList<Carre> findAll() {
        ArrayList<Carre> find = new ArrayList<Carre>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT variableName FROM Carre");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("variableName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Carre>();
        }
        return find;
    }
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    @Override
    public Carre update(final Carre object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        final Carre before = this.find(object.getVariableName());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Carre SET topLeft_x = ?, topLeft_y = ?, "
                + "longueur = ? WHERE variableName = ?");
                prepare.setInt(un, object.getTopLeft().getX());
                prepare.setInt(deux, object.getTopLeft().getY());
                prepare.setInt(trois, object.getLongueur());
                prepare.setString(quatre, object.getVariableName());
                prepare.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return before;
            }
        } else {
            return null;
        }
        return object;
    }
    /**
     * supprime un élément du DAO.
     * @param object élément à supprimer
     */
    @Override
    public void delete(final Carre object) {
        final int un = 1;
        try {
            this.deleteComposant(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Carre WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "DELETE FROM Forme WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
