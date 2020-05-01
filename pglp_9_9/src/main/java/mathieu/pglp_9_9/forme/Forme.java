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
     * obtenir le nom de variable de la forme.
     * @return le nom de variable de la forme
     */
    public String getVariableName() {
        return variableName + "";
    }
    /**
     * modifier le nom de variable de la forme.
     * @param newVariableName nouvelle valeur
     */
    public void setVariableName(final String newVariableName) {
        variableName = newVariableName + "";
    }
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
