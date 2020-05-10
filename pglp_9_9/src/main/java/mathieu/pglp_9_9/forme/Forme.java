package mathieu.pglp_9_9.forme;

/**
 * classe principale des formes.
 */
public abstract class Forme {
    /**
     * nom de variable.
     */
    private String variableName;
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
     * @param newVariableName définir le nom de la variable de la forme
     */
    protected Forme(final String newVariableName) {
        this.variableName = newVariableName;
    }
    /**
     * deplace une forme.
     * @param x déplacement en abscisse
     * @param y deplacement en ordonée
     */
    public abstract void deplace(int x, int y);
    /**
     * affiche la forme.
     */
    public void affiche() {
        System.out.print(variableName + " : ");
    }
}
