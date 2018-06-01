package ar.com.redbee.socialmediaaggregator.commons.linq;

/**
 * The type Predicates.
 */
public class Predicates {
    /**
     * Returns true when the object is null.
     *
     * @param <T> the type parameter
     * @return predicate predicate
     */
    public static <T> Predicate<T> isNull() {
        return new Predicate<T>() {
            @Override
            public boolean eval(T object) {
                return object == null;
            }
        };
    }

    /**
     * Returns true when the object is not null.
     *
     * @param <T> the type parameter
     * @return predicate predicate
     */
    public static <T> Predicate<T> isNotNull() {
        return new Predicate<T>() {
            @Override
            public boolean eval(T object) {
                return object != null;
            }
        };
    }
}
