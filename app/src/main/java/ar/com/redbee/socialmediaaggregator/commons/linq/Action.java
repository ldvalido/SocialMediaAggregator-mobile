package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <T> the type parameter
 */
public interface Action<T> {
    /**
     * Eval.
     *
     * @param item the item
     */
    void eval(T item);
}
