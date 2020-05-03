package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Rectangle;

/**
 * dao pour opération JDBC sur le Rectangle.
 */
public class DaoRectangleJDBC extends AbstractDao<Rectangle> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoRectangleJDBC(final Connection c) {
        connect = c;
    }
    /**
     * supprime toutes les associations
     * de la forme contenu dans les groupes.
     * @param id identifiant de la forme 
     */
    private void deleteCompositionRectangle(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionRectangle WHERE idComposant = ?");
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
    public Rectangle create(final Rectangle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4,cinq = 5;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO Rectangle"
            + " (variableName,topLeft_x,topLeft_y,longueur,largeur)"
            + " VALUES(?, ?, ?, ?, ?)");
            prepare.setString(un, object.getVariableName());
            prepare.setInt(deux, object.getTopLeft().getX());
            prepare.setInt(trois, object.getTopLeft().getY());
            prepare.setInt(quatre, object.getLongueur());
            prepare.setInt(cinq, object.getLargeur());
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
    public Rectangle find(final String id) {
        final int un = 1;
        Rectangle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Rectangle WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position p = new Position(
                        result.getInt("topLeft_x"),
                        result.getInt("topLeft_y")
                );
                find = new Rectangle(id,p, 
                        result.getInt("longueur"),
                        result.getInt("largeur")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    @Override
    public Rectangle update(final Rectangle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4, cinq = 5;
        final Rectangle before = this.find(object.getVariableName());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Rectangle SET topLeft_x = ?, topLeft_y = ?, "
                + "longueur = ?, largeur = ? WHERE variableName = ?");
                prepare.setInt(un, object.getTopLeft().getX());
                prepare.setInt(deux, object.getTopLeft().getY());
                prepare.setInt(trois, object.getLongueur());
                prepare.setInt(cinq, object.getLargeur());
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
    public void delete(final Rectangle object) {
        final int un = 1;
        try {
            this.deleteCompositionRectangle(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Rectangle WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
