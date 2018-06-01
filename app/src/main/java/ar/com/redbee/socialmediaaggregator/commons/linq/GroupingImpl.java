package ar.com.redbee.socialmediaaggregator.commons.linq;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Date: 07/05/13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 *
 * @param <TKey>     the type parameter
 * @param <TElement> the type parameter
 */
public class GroupingImpl<TKey, TElement> extends ArrayList<TElement> implements Grouping<TKey, TElement> {
    /**
     * The Key.
     */
    TKey key;

    /**
     * Instantiates a new Grouping.
     */
    public GroupingImpl() {

    }

    /**
     * Instantiates a new Grouping.
     *
     * @param key     the key
     * @param element the element
     */
    public GroupingImpl(TKey key, TElement element) {
        this.key = key;
        add(element);
    }

    public TKey getKey() {
        return key;
    }

    public void setKey(TKey key) {
        this.key = key;
    }
}