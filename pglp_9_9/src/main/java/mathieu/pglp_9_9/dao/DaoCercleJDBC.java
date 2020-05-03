package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Position;

public class DaoCercleJDBC extends AbstractDao<Cercle> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoCercleJDBC(Connection c) {
        connect = c;
    }
    
    private void deleteCompositionCercle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCercle WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Cercle create(Cercle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        try {
            PreparedStatement prepare = connect.prepareStatement(
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

    @Override
    public Cercle find(String id) {
        final int un = 1;
        Cercle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Cercle WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position centre = new Position(result.getInt("centre_x"),result.getInt("centre_y"));
                find = new Cercle(id,centre, result.getInt("rayon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public Cercle update(Cercle object) {
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

    @Override
    public void delete(Cercle object) {
        final int un = 1;
        try {
            this.deleteCompositionCercle(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Cercle WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
