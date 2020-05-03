package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mathieu.pglp_9_9.GroupeForme;
import mathieu.pglp_9_9.dao.AbstractDaoFactory.DaoType;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

public class DaoGroupeFormeJDBC extends AbstractDao<GroupeForme> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoGroupeFormeJDBC(Connection c) {
        connect = c;
    }
    
    public void createCompositionCercle(String idGroupe, String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO CompositionCercle"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void createCompositionCarre(String idGroupe, String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO CompositionCarre"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void createCompositionRectangle(String idGroupe, String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO CompositionRectangle"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void createCompositionTriangle(String idGroupe, String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO CompositionTriangle"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void createCompositionGroupe(String idGroupe, String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO CompositionGroupe"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public ArrayList<Forme> findCompositionCercle(String id){
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant FROM CompositionCercle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDaoFactory factory = AbstractDaoFactory.getFactory(DaoType.JDBC);
            AbstractDao<Cercle> dao = factory.getDaoCercle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    
    public ArrayList<Forme> findCompositionCarre(String id){
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant FROM CompositionCarre WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDaoFactory factory = AbstractDaoFactory.getFactory(DaoType.JDBC);
            AbstractDao<Carre> dao = factory.getDaoCarre();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    
    public ArrayList<Forme> findCompositionRectangle(String id){
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant FROM CompositionRectangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDaoFactory factory = AbstractDaoFactory.getFactory(DaoType.JDBC);
            AbstractDao<Rectangle> dao = factory.getDaoRectangle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    
    public ArrayList<Forme> findCompositionTriangle(String id){
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant FROM CompositionTriangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDaoFactory factory = AbstractDaoFactory.getFactory(DaoType.JDBC);
            AbstractDao<Triangle> dao = factory.getDaoTriangle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    
    public ArrayList<Forme> findCompositionGroupe(String id){
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant FROM CompositionGroupe WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDaoFactory factory = AbstractDaoFactory.getFactory(DaoType.JDBC);
            AbstractDao<GroupeForme> dao = factory.getDaoGroupeForme();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    
    public ArrayList<Forme> findComposition(String id) {
        ArrayList<Forme> all = new ArrayList<Forme>();
        all.addAll(this.findCompositionCercle(id));
        all.addAll(this.findCompositionCarre(id));
        all.addAll(this.findCompositionRectangle(id));
        all.addAll(this.findCompositionTriangle(id));
        all.addAll(this.findCompositionGroupe(id));
        return all;
    }
    
    public void deleteCompositionCercle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCercle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteCompositionCarre(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCarre WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteCompositionRectangle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionRectangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteCompositionTriangle(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionTriangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteCompositionGroupe(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionGroupe WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void deleteComposition(String id) {
        this.deleteCompositionCercle(id);
        this.deleteCompositionCarre(id);
        this.deleteCompositionRectangle(id);
        this.deleteCompositionTriangle(id);
        this.deleteCompositionGroupe(id);
    }
    
    private void deleteGroupeComposition(String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionGroupe WHERE idComposant = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public GroupeForme create(GroupeForme object) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO GroupeForme"
            + " (variableName)"
            + " VALUES(?)");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
            DaoFactoryJDBC factory = (DaoFactoryJDBC) AbstractDaoFactory.getFactory(DaoType.JDBC);
            for (Forme f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                    AbstractDao<Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                    this.createCompositionCercle(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                    this.createCompositionCarre(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                    this.createCompositionRectangle(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                    this.createCompositionTriangle(object.getVariableName(), f.getVariableName());
                }
                else {
                    this.create((GroupeForme) f);
                    this.createCompositionGroupe(object.getVariableName(), f.getVariableName());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }

    @Override
    public GroupeForme find(String id) {
        final int un = 1;
        GroupeForme find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM GroupeForme WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                find = new GroupeForme(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
    }

    @Override
    public GroupeForme update(GroupeForme object) {
        ArrayList<Forme> contenu = this.findComposition(object.getVariableName());
        if (!contenu.isEmpty()) {
            this.deleteComposition(object.getVariableName());
            DaoFactoryJDBC factory = (DaoFactoryJDBC) AbstractDaoFactory.getFactory(DaoType.JDBC);
            for (Forme f : object.getList()){
                if (f.getClass() == Cercle.class) {
                    AbstractDao<Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                    this.createCompositionCercle(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                    this.createCompositionCarre(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                    this.createCompositionRectangle(object.getVariableName(), f.getVariableName());
                }
                else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                    this.createCompositionTriangle(object.getVariableName(), f.getVariableName());
                }
                else {
                    this.create((GroupeForme) f);
                    this.createCompositionGroupe(object.getVariableName(), f.getVariableName());
                }
            }
        } else {
            return null;
        }
        return object;
    }

    @Override
    public void delete(GroupeForme object) {
        final int un = 1;
        try {
            this.deleteComposition(object.getVariableName());
            this.deleteGroupeComposition(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM GroupeForme WHERE variableName = ?");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
