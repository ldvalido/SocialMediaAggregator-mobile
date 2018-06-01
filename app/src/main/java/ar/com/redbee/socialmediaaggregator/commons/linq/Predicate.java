package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <T> the type parameter
 */
public interface Predicate<T> {
    /**
     * Eval boolean.
     *
     * @param item the item
     * @return the boolean
     */
    boolean eval(T item);
}
