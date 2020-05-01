package mathieu.pglp_9_9.forme;

/**
 * classe principale des formes.
 */
public abstract class Forme {
    /**
     * nom de variable.
     */
    protected String variableName;
    /**
     * constructeur pour définir la variable.
     * @param nom_de_variable définir le nom de la variable de la forme
     */
    protected Forme(String nom_de_variable) {
        this.variableName = nom_de_variable;
    }
    /**
     * deplace une forme.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    public abstract void deplace(final int x, final int y);
    /**
     * affiche la forme.
     */
    public abstract void affiche();
}
