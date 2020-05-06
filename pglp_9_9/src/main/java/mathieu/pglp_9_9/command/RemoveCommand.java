package mathieu.pglp_9_9.command;

import java.util.ArrayList;

import mathieu.pglp_9_9.dao.AbstractDao;
import mathieu.pglp_9_9.dao.DaoFactoryJDBC;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
  * commande pour supprimer une ou plusieurs formes.
  */
public class RemoveCommand implements Command {
    /**
     * liste des formes à supprimer.
     */
    private ArrayList<Forme> list;
    /**
     * constructeur de la classe.
     * @param f liste des formes à retirer
     */
    public RemoveCommand(final ArrayList<Forme> f) {
        list = f;
    }
    /**
     * execution de la commande.
     */
    public void execute() {
        System.out.println(list.size());
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        for (Forme forme : list) {
            if (forme.getClass() == Cercle.class) {
                AbstractDao<Cercle> dao = factory.getDaoCercle();
                dao.delete((Cercle) forme);
            } else if (forme.getClass() == Carre.class) {
                AbstractDao<Carre> dao = factory.getDaoCarre();
                dao.delete((Carre) forme);
            } else if (forme.getClass() == Rectangle.class) {
                AbstractDao<Rectangle> dao = factory.getDaoRectangle();
                dao.delete((Rectangle) forme);
            } else if (forme.getClass() == Triangle.class) {
                AbstractDao<Triangle> dao = factory.getDaoTriangle();
                dao.delete((Triangle) forme);
            } else {
                AbstractDao<GroupeForme> dao = factory.getDaoGroupeForme();
                dao.delete((GroupeForme) forme);
            }
            System.out.println("Suppression de la forme "
            + forme.getVariableName() + " réussi.");
        }
        factory.close();
    }
}
