package ar.com.redbee.socialmediaaggregator.commons.linq;

import java.util.List;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <TKey>     the type parameter
 * @param <TElement> the type parameter
 */
public interface Grouping<TKey, TElement> extends List<TElement> {
    /**
     * Gets key.
     *
     * @return the key
     */
    TKey getKey();

    /**
     * Sets key.
     *
     * @param key the key
     */
    void setKey(TKey key);
}
