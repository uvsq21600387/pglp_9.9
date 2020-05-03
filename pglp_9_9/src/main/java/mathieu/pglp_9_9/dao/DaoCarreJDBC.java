package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Position;

public class DaoCarreJDBC extends AbstractDao<Carre> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoCarreJDBC(Connection c) {
        connect = c;
    }
    
    private void deleteCompositionCarre(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCarre WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public Carre create(Carre object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4;
        try {
            PreparedStatement prepare = connect.prepareStatement(
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

    @Override
    public Carre find(String id) {
        final int un = 1;
        Carre find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Carre WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position p = new Position(result.getInt("topLeft_x"),result.getInt("topLeft_y"));
                find = new Carre(id,p, result.getInt("longueur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public Carre update(Carre object) {
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

    @Override
    public void delete(Carre object) {
        final int un = 1;
        try {
            this.deleteCompositionCarre(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Carre WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
