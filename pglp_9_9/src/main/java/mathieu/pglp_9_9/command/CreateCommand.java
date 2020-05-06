package mathieu.pglp_9_9.command;

import mathieu.pglp_9_9.dao.AbstractDao;
import mathieu.pglp_9_9.dao.DaoFactoryJDBC;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * commande pour créer une forme.
 */
public class CreateCommand implements Command {
    /**
     * forme à créer.
     */
    private Forme forme;
    /**
     * constructeur de la classe.
     * @param f forme à créer
     */
    public CreateCommand(final Forme f) {
        forme = f;
    }
    /**
     * execution de la commande.
     */
    public void execute() {
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        if (forme.getClass() == Cercle.class) {
            AbstractDao<Cercle> dao = factory.getDaoCercle();
            dao.create((Cercle) forme);
        } else if (forme.getClass() == Carre.class) {
            AbstractDao<Carre> dao = factory.getDaoCarre();
            dao.create((Carre) forme);
        } else if (forme.getClass() == Rectangle.class) {
            AbstractDao<Rectangle> dao = factory.getDaoRectangle();
            dao.create((Rectangle) forme);
        } else if (forme.getClass() == Triangle.class) {
            AbstractDao<Triangle> dao = factory.getDaoTriangle();
            dao.create((Triangle) forme);
        } else {
            AbstractDao<GroupeForme> dao = factory.getDaoGroupeForme();
            dao.create((GroupeForme) forme);
        }
        factory.close();
        System.out.println("Ajout de la forme "
        + forme.getVariableName() + " réussi.");
    }
}
