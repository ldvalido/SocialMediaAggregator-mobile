package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface ActionMap<K, V> {
    /**
     * Eval.
     *
     * @param key   the key
     * @param value the value
     */
    void eval(K key, V value);
}
