package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Rectangle;

public class DaoRectangleJDBC extends AbstractDao<Rectangle> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoRectangleJDBC(Connection c) {
        connect = c;
    }
    
    private void deleteCompositionRectangle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionRectangle WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public Rectangle create(Rectangle object) {
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

    @Override
    public Rectangle find(String id) {
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

    @Override
    public Rectangle update(Rectangle object) {
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

    @Override
    public void delete(Rectangle object) {
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
