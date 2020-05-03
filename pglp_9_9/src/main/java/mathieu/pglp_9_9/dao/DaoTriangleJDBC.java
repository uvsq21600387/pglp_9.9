package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Triangle;

public class DaoTriangleJDBC extends AbstractDao<Triangle> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoTriangleJDBC(Connection c) {
        connect = c;
    }
    
    private void deleteCompositionTriangle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionTriangle WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public Triangle create(Triangle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4,cinq = 5, six = 6, sept = 7;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO Triangle"
            + " (variableName,"
            + "point1_x,point1_y,"
            + "point2_x,point2_y,"
            + "point3_x,point3_y,)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(un, object.getVariableName());
            prepare.setInt(deux, object.getPosition(0).getX());
            prepare.setInt(trois, object.getPosition(0).getY());
            prepare.setInt(quatre, object.getPosition(1).getX());
            prepare.setInt(cinq, object.getPosition(1).getY());
            prepare.setInt(six, object.getPosition(2).getX());
            prepare.setInt(sept, object.getPosition(2).getY());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }

    @Override
    public Triangle find(String id) {
        final int un = 1;
        Triangle find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM Triangle WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Position p[] = {
                    new Position(
                            result.getInt("point1_x"),
                            result.getInt("point1_y")),
                    new Position(
                            result.getInt("point2_x"),
                            result.getInt("point2_y")),
                    new Position(
                            result.getInt("point3_x"),
                            result.getInt("point3_y")),
                };
                find = new Triangle(id, p[0],p[1], p[2]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public Triangle update(Triangle object) {
        final int un = 1, deux = 2, trois = 3, quatre = 4,cinq = 5, six = 6, sept = 7;
        final Triangle before = this.find(object.getVariableName());
        if (before != null) {
            try {
                PreparedStatement prepare = connect.prepareStatement(
                "UPDATE Triangle SET point1_x = ?, point1_y = ?, "
                + "point2_x = ?, point2_y = ?, point3_x = ?, point3_y = ?"
                + " WHERE variableName = ?");
                prepare.setInt(un, object.getPosition(0).getX());
                prepare.setInt(deux, object.getPosition(0).getY());
                prepare.setInt(trois, object.getPosition(1).getX());
                prepare.setInt(quatre, object.getPosition(1).getY());
                prepare.setInt(cinq, object.getPosition(2).getX());
                prepare.setInt(six, object.getPosition(2).getY());
                prepare.setString(sept, object.getVariableName());
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
    public void delete(Triangle object) {
        final int un = 1;
        try {
            this.deleteCompositionTriangle(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Triangle WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
