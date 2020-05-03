package mathieu.pglp_9_9.dao;

/**
 * classe abstraite pour tous les dao.
 * @param <T> type de forme
 */
public abstract class AbstractDao<T> {
    /**
     * ajoute un élément au DAO.
     * @param object l'élément à ajouter
     * @return la creation
     */
    public abstract T create(T object);
    /**
     * obtenir un élément par son identifiant.
     * @param id identifiant de l'élément à obtenir
     * @return l'élément souhaité
     */
    public abstract T find(String id);
    /**
     * modifie un élément du DAO.
     * @param object l'élément à modifier
     * @return la modification
     */
    public abstract T update(T object);
    /**
     * supprime un élément du DAO.
     * @param object élément à supprimer
     */
    public abstract void delete(T object);
}
