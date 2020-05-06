package mathieu.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * dao pour opération JDBC sur les groupes de formes.
 */
public class DaoGroupeFormeJDBC extends AbstractDao<GroupeForme> {
    /**
     * connection à la bdd.
     */
    private final Connection connect;
    /**
     * constructeur de la classe.
     * @param c connection pour la bdd
     */
    public DaoGroupeFormeJDBC(final Connection c) {
        connect = c;
    }
    /**
     * créé une association d'un groupe qui contient une forme.
     * @param idGroupe groupe qui contient
     * @param idComposant forme qui compose le groupe
     */
    public void createComposition(
            final String idGroupe, final String idComposant) {
        final int un = 1, deux = 2;
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO Composition"
            + " (idGroupe, idComposant)"
            + " VALUES(?, ?)");
            prepare.setString(un, idGroupe);
            prepare.setString(deux, idComposant);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * recherche toutes les associations d'un groupe qui contient des formes.
     * @param id identifiant du groupe
     * @return listes des composants du groupe
     */
    public ArrayList<Forme> findComposition(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM Composition WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            AbstractDao<Cercle> daoCe = factory.getDaoCercle();
            AbstractDao<Carre> daoCa = factory.getDaoCarre();
            AbstractDao<Rectangle> daoR = factory.getDaoRectangle();
            AbstractDao<Triangle> daoT = factory.getDaoTriangle();
            while (result.next()) {
                Forme f = daoCe.find(result.getString("idComposant"));
                if (f == null) {
                    f = daoCa.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = daoR.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = daoT.find(result.getString("idComposant"));
                }
                if (f == null) {
                    f = this.find(result.getString("idComposant"));
                }
                find.add(f);
            }
            factory.close();
        } catch (SQLException e) {
            factory.close();
            return new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * retire toutes les associations d'un groupe qui contient des formes.
     * @param id identifiant du groupe
     */
    public void deleteComposition(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM Composition WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
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
    public GroupeForme create(final GroupeForme object) {
        final int un = 1;
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "INSERT INTO Forme"
                    + " (variableName)"
                    + " VALUES(?)");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
            prepare = connect.prepareStatement(
                    "INSERT INTO GroupeForme"
                    + " (variableName)"
                    + " VALUES(?)");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
            for (Forme f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                    AbstractDao<Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                } else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((GroupeForme) f);
                }
                this.createComposition(
                        object.getVariableName(), f.getVariableName());
            }
            factory.close();
        } catch (SQLException e) {
            factory.close();
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
    public GroupeForme find(final String id) {
        final int un = 1;
        GroupeForme find = null;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT * FROM GroupeForme WHERE variableName = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                find = new GroupeForme(id);
                ArrayList<Forme> list = findComposition(id);
                for (Forme f : list) {
                    find.add(f);
                }
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
    public ArrayList<GroupeForme> findAll() {
        ArrayList<GroupeForme> find = new ArrayList<GroupeForme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT variableName FROM GroupeForme");
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                find.add(this.find(result.getString("variableName")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<GroupeForme>();
        }
        return find;
    }
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    @Override
    public GroupeForme update(final GroupeForme object) {
        ArrayList<Forme> contenu = this.findComposition(
                object.getVariableName());
        if (!contenu.isEmpty()) {
            this.deleteComposition(object.getVariableName());
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            for (Forme f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                    AbstractDao<Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                } else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((GroupeForme) f);
                }
                this.createComposition(
                        object.getVariableName(), f.getVariableName());
            }
            factory.close();
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
    public void delete(final GroupeForme object) {
        final int un = 1;
        try {
            this.deleteComposition(object.getVariableName());
            this.deleteComposant(object.getVariableName());
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM GroupeForme WHERE variableName = ?");
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
