package mathieu.pglp_9_9.command;

import java.util.ArrayList;

import mathieu.pglp_9_9.forme.Forme;

/**
 * commande pour afficher des formes.
 */
public class AfficheCommand implements Command {
    /**
     * liste des formes à afficher.
     */
    private ArrayList<Forme> list;
    /**
     * constructeur de la classe.
     * @param f formes à afficher
     */
    public AfficheCommand(final ArrayList<Forme> f) {
        list = f;
    }
    /**
     * execution de la commande.
     */
    public void execute() {
        for (Forme f : list) {
            f.affiche();
        }
    }
}
