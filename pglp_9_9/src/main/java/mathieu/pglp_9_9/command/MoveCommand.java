package mathieu.pglp_9_9.command;

import mathieu.pglp_9_9.dao.AbstractDao;
import mathieu.pglp_9_9.dao.DaoFactoryJDBC;
import mathieu.pglp_9_9.forme.Carre;
import mathieu.pglp_9_9.forme.Cercle;
import mathieu.pglp_9_9.forme.Forme;
import mathieu.pglp_9_9.forme.GroupeForme;
import mathieu.pglp_9_9.forme.Position;
import mathieu.pglp_9_9.forme.Rectangle;
import mathieu.pglp_9_9.forme.Triangle;

/**
 * commande pour déplacer une forme.
 */
public class MoveCommand implements Command {
    /**
     * forme à déplacer.
     */
    private Forme forme;
    /**
     * vecteur de deplacement de la forme.
     */
    private Position vecteur;
    /**
     * constructeur de la classe.
     * @param f forme à déplacer
     * @param vecteurDeplacement vecteur de déplacement de la forme
     */
    public MoveCommand(final Forme f, final Position vecteurDeplacement) {
        this.vecteur = vecteurDeplacement;
        forme = f;
    }
    /**
     * execution de la commande.
     */
    public void execute() {
        forme.deplace(vecteur.getX(), vecteur.getY());
        DaoFactoryJDBC factory = new DaoFactoryJDBC();
        if (forme.getClass() == Cercle.class) {
            AbstractDao<Cercle> dao = factory.getDaoCercle();
            dao.update((Cercle) forme);
        } else if (forme.getClass() == Carre.class) {
            AbstractDao<Carre> dao = factory.getDaoCarre();
            dao.update((Carre) forme);
        } else if (forme.getClass() == Rectangle.class) {
            AbstractDao<Rectangle> dao = factory.getDaoRectangle();
            dao.update((Rectangle) forme);
        } else if (forme.getClass() == Triangle.class) {
            AbstractDao<Triangle> dao = factory.getDaoTriangle();
            dao.update((Triangle) forme);
        } else {
            AbstractDao<GroupeForme> dao = factory.getDaoGroupeForme();
            dao.update((GroupeForme) forme);
        }
        factory.close();
    }
}
