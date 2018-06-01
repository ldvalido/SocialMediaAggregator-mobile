package ar.com.redbee.socialmediaaggregator.repository.commons;

import com.j256.ormlite.stmt.QueryBuilder;

import java.util.List;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <T> the type parameter
 */
public interface
Repository<T extends Identifiable> {

    /**
     * Get t.
     *
     * @param id the id
     * @return the t
     */
    public T get(Integer id);

    /**
     * Find first t.
     *
     * @param fieldName  the field name
     * @param fieldValue the field value
     * @return the t
     */
    public T findFirst(String fieldName, String fieldValue);

    /**
     * Find like first t.
     *
     * @param fieldName  the field name
     * @param fieldValue the field value
     * @return the t
     */
    public T findLikeFirst(String fieldName, String fieldValue);

    /**
     * Filter list.
     *
     * @param fieldName  the field name
     * @param fieldValue the field value
     * @return the list
     */
    public List<T> filter(String fieldName, Object fieldValue);

    /**
     * Filter like list.
     *
     * @param fieldName  the field name
     * @param fieldValue the field value
     * @return the list
     */
    public List<T> filterLike(String fieldName, Object fieldValue);

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll();

    /**
     * Add.
     *
     * @param item the item
     */
    public void add(T item);

    /**
     * Update t.
     *
     * @param item the item
     * @return the t
     */
    public T update(T item);

    public T addOrUpdate(T item);
    /**
     * Gets by limit.
     *
     * @param max the max
     * @return the by limit
     */
    public List<T> getByLimit(Integer max);

    /**
     * Remove.
     *
     * @param id the id
     */
    public void remove(Integer id);
    QueryBuilder<T, Integer> getQueryBuilder();

}
