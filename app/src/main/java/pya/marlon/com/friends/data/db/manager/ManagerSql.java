package pya.marlon.com.friends.data.db.manager;

import java.util.List;

/**
 * Created by marlonpya on 23/07/17.
 */

public interface ManagerSql<C> {

    /**
     *
     * @return PrimaryKey
     */
    String primaryKey();

    /**
     * auto-increment
     * @return Last id
     */
    int lastId();

    /**
     * Create or update by object
     * @param object
     */
    void createOrUpdate(C object);

    /**
     * Create objects by iterador
     * @param list
     */
    void createOrUpdate(List<C> list);

    /**
     * Read
     * @return object object
     */
    C getById(int id);

    /**
     * Get List of objects
     * @return
     */
    List<C> getListByKey(String key, Object value);

    /**
     * Delete by id
     * @param id by object
     */
    void deleteById(int id);

    @SuppressWarnings("removed all realm")
    void delete();
}
