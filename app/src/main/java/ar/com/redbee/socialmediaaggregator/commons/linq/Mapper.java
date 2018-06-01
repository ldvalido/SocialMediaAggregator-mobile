package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * Created by lvalido on 01/01/1900.
 *
 * @param <T> the type parameter
 * @param <S> the type parameter
 */
public interface Mapper<T, S> {
    /**
     * Map s.
     *
     * @param item the item
     * @return the s
     */
    S map(T item);
}
