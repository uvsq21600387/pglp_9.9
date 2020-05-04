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
     * créé une association d'un groupe qui contient un Cercle.
     * @param idGroupe groupe qui contient
     * @param idComposant forme qui compose le groupe
     */
    public void createCompositionCercle(
            final String idGroupe, final String idComposant) {
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
    /**
     * créé une association d'un groupe qui contient un Carré.
     * @param idGroupe groupe qui contient
     * @param idComposant forme qui compose le groupe
     */
    public void createCompositionCarre(
            final String idGroupe, final String idComposant) {
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
    /**
     * créé une association d'un groupe qui contient un Rectangle.
     * @param idGroupe groupe qui contient
     * @param idComposant forme qui compose le groupe
     */
    public void createCompositionRectangle(
            final String idGroupe, final String idComposant) {
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
    /**
     * créé une association d'un groupe qui contient un triangle.
     * @param idGroupe groupe qui contient
     * @param idComposant forme qui compose le groupe
     */
    public void createCompositionTriangle(
            final String idGroupe, final String idComposant) {
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
    /**
     * créé une association d'un groupe qui contient un groupe.
     * @param idGroupe groupe qui contient
     * @param idComposant groupe qui compose le groupe
     */
    public void createCompositionGroupe(
            final String idGroupe, final String idComposant) {
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
    /**
     * recherche toutes les associations d'un groupe qui contient des Cercles.
     * @param id identifiant du groupe
     * @return listes des composants de type Cercle du groupe
     */
    public ArrayList<Forme> findCompositionCercle(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM CompositionCercle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<Cercle> dao = factory.getDaoCercle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * recherche toutes les associations d'un groupe qui contient des Carrés.
     * @param id identifiant du groupe
     * @return listes des composants de type Carre du groupe
     */
    public ArrayList<Forme> findCompositionCarre(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM CompositionCarre WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<Carre> dao = factory.getDaoCarre();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * recherche toutes les associations d'un
     * groupe qui contient des Rectangles.
     * @param id identifiant du groupe
     * @return listes des composants de type Rectangle du groupe
     */
    public ArrayList<Forme> findCompositionRectangle(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM CompositionRectangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<Rectangle> dao = factory.getDaoRectangle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * recherche toutes les associations d'un groupe qui contient des triangles.
     * @param id identifiant du groupe
     * @return listes des composants de type Triangle du groupe
     */
    public ArrayList<Forme> findCompositionTriangle(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM CompositionTriangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<Triangle> dao = factory.getDaoTriangle();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * recherche toutes les associations d'un groupe qui contient des groupes.
     * @param id identifiant du groupe
     * @return listes des composants de type groupe du groupe
     */
    public ArrayList<Forme> findCompositionGroupe(final String id) {
        final int un = 1;
        ArrayList<Forme> find = new ArrayList<Forme>();
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "SELECT idComposant "
                    + "FROM CompositionGroupe WHERE idGroupe = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            AbstractDao<GroupeForme> dao = factory.getDaoGroupeForme();
            while (result.next()) {
                find.add(dao.find(result.getString("idComposant")));
            }
        } catch (SQLException e) {
            new ArrayList<Forme>();
        }
        return find;
    }
    /**
     * recherche toutes les associations d'un groupe qui contient des formes.
     * @param id identifiant du groupe
     * @return listes des composants du groupe
     */
    public ArrayList<Forme> findComposition(final String id) {
        ArrayList<Forme> all = new ArrayList<Forme>();
        all.addAll(this.findCompositionCercle(id));
        all.addAll(this.findCompositionCarre(id));
        all.addAll(this.findCompositionRectangle(id));
        all.addAll(this.findCompositionTriangle(id));
        all.addAll(this.findCompositionGroupe(id));
        return all;
    }
    /**
     * retire toutes les associations d'un groupe qui contient des Cercles.
     * @param id identifiant du groupe
     */
    public void deleteCompositionCercle(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCercle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * retire toutes les associations d'un groupe qui contient des Carrés.
     * @param id identifiant du groupe
     */
    public void deleteCompositionCarre(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionCarre WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * retire toutes les associations d'un groupe qui contient des Rectangles.
     * @param id identifiant du groupe
     */
    public void deleteCompositionRectangle(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionRectangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * retire toutes les associations d'un groupe qui contient des Triangles.
     * @param id identifiant du groupe
     */
    public void deleteCompositionTriangle(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionTriangle WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * retire toutes les associations d'un groupe qui contient des groupes.
     * @param id identifiant du groupe
     */
    public void deleteCompositionGroupe(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionGroupe WHERE idGroupe = ?");
            prepare.setString(un, id);
            prepare.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     * retire toutes les associations d'un groupe qui contient des formes.
     * @param id identifiant du groupe
     */
    public void deleteComposition(final String id) {
        this.deleteCompositionCercle(id);
        this.deleteCompositionCarre(id);
        this.deleteCompositionRectangle(id);
        this.deleteCompositionTriangle(id);
        this.deleteCompositionGroupe(id);
    }
    /**
     * supprime toutes les associations
     * du groupe contenu dans les groupes.
     * @param id identifiant de la forme
     */
    private void deleteGroupeComposition(final String id) {
        final int un = 1;
        try {
            PreparedStatement prepare = connect.prepareStatement(
                    "DELETE FROM CompositionGroupe WHERE idComposant = ?");
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
        try {
            PreparedStatement prepare = connect.prepareStatement(
            "INSERT INTO GroupeForme"
            + " (variableName)"
            + " VALUES(?)");
            prepare.setString(un, object.getVariableName());
            prepare.executeUpdate();
            DaoFactoryJDBC factory = new DaoFactoryJDBC();
            for (Forme f : object.getList()) {
                if (f.getClass() == Cercle.class) {
                    AbstractDao<Cercle> dao = factory.getDaoCercle();
                    dao.create((Cercle) f);
                    this.createCompositionCercle(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                    this.createCompositionCarre(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                    this.createCompositionRectangle(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                    this.createCompositionTriangle(
                            object.getVariableName(), f.getVariableName());
                } else {
                    this.create((GroupeForme) f);
                    this.createCompositionGroupe(
                            object.getVariableName(), f.getVariableName());
                }
            }
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
                    "SELECT variableName FROM Triangle");
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
                    this.createCompositionCercle(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Carre.class) {
                    AbstractDao<Carre> dao = factory.getDaoCarre();
                    dao.create((Carre) f);
                    this.createCompositionCarre(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Rectangle.class) {
                    AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                    dao.create((Rectangle) f);
                    this.createCompositionRectangle(
                            object.getVariableName(), f.getVariableName());
                } else if (f.getClass() == Triangle.class) {
                    AbstractDao<Triangle> dao = factory.getDaoTriangle();
                    dao.create((Triangle) f);
                    this.createCompositionTriangle(
                            object.getVariableName(), f.getVariableName());
                } else {
                    this.create((GroupeForme) f);
                    this.createCompositionGroupe(
                            object.getVariableName(), f.getVariableName());
                }
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
    public void delete(final GroupeForme object) {
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
