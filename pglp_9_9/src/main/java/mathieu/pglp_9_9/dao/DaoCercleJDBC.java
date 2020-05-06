package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Position;

/**
 * dao pour opération JDBC sur le Cercle.
 */
public class DaoCercleJDBC extends AbstractDao<Cercle> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoCercleJDBC(final Connection c) {
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
    public Cercle create(final Cercle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Forme"
                    + " (variableName)"
                    + " VALUES(?)");
                    prepare.setString(un, object.getVariableName());
                    prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO Cercle"
                    + " (variableName,centre_x,centre_y,rayon)"
                    + " VALUES(?, ?, ?, ?)");
            prepare.setString(un, object.getVariableName());
            prepare.setInt(deux, object.getCentre().getX());
            prepare.setInt(trois, object.getCentre().getY());
            prepare.setInt(quatre, object.getRayon());
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
    public Cercle find(final String id) {
        final int un = 1;
        Cercle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Cercle WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position centre = new Position(
                        result.getInt("centre_x"),
                        result.getInt("centre_y"));
                find = new Cercle(id, centre, result.getInt("rayon"));
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
    public ArrayList<Cercle> findAll() {
        ArrayList<Cercle> find = new ArrayList<Cercle>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT variableName FROM Cercle");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("variableName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<Cercle>();
        }
        return find;
    }
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    @Override
    public Cercle update(final Cercle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        final Cercle before = this.find(object.getVariableName());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Cercle SET centre_x = ?, centre_y = ?, "
                + "rayon = ? WHERE id = ?");
                prepare.setInt(un, object.getCentre().getX());
                prepare.setInt(deux, object.getCentre().getY());
                prepare.setInt(trois, object.getRayon());
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
    public void delete(final Cercle object) {
        final int un = 1;
        try {
            this.deleteComposant(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Cercle WHERE variableName = ?");
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
