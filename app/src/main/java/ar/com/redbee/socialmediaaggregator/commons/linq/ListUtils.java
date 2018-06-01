package ar.com.redbee.socialmediaaggregator.commons.linq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by lvalido on 01/01/1900.
 */
public class ListUtils {
    /**
     * Is null or empty boolean.
     *
     * @param collection the collection
     * @return the boolean
     */
    public static boolean isNullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Is null or empty boolean.
     *
     * @param array the array
     * @return the boolean
     */
    public static boolean isNullOrEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Each.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param action     the action
     */
    public static <T> void each(Collection<T> collection, Action<T> action) {
        if (!isNullOrEmpty(collection))
            for (T item : collection) {
                action.eval(item);
            }
    }

    /**
     * Each.
     *
     * @param <K>    the type parameter
     * @param <V>    the type parameter
     * @param map    the map
     * @param action the action
     */
    public static <K, V> void each(Map<K, V> map, ActionMap<K, V> action) {
        if (map != null && !map.isEmpty()) {
            for (K key : map.keySet()) {
                action.eval(key, map.get(key));
            }
        }
    }

    /**
     * First t.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the t
     */
    public static <T> T first(List<T> list) {
        if (isNullOrEmpty(list))
            return null;

        return list.get(0);
    }

    /**
     * First t.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the t
     */
    public static <T> T first(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return null;
        }
        for (T item : collection) {
            if (predicate.eval(item)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Last t.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the t
     */
    public static <T> T last(List<T> list) {
        if (isNullOrEmpty(list))
            return null;

        return list.get(list.size() - 1);
    }

    /**
     * Pop t.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the t
     */
    public static <T> T pop(List<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return null;
        }
        for (T item : collection) {
            if (predicate.eval(item)) {
                collection.remove(item);
                return item;
            }
        }
        return null;
    }

    /**
     * Sum int.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param mapper     the mapper
     * @return the int
     */
    public static <T> int sum(List<T> collection, Mapper<T, Integer> mapper) {
        if (collection == null) {
            return 0;
        }

        int sum = 0;
        for (T item : collection) {
            sum += mapper.map(item);
        }
        return sum;
    }

    /**
     * Map list.
     *
     * @param <T>        the type parameter
     * @param <S>        the type parameter
     * @param collection the collection
     * @param mapper     the mapper
     * @return the list
     */
    public static <T, S> List<S> map(List<T> collection, Mapper<T, S> mapper) {
        if (collection == null) {
            return new ArrayList<>();
        }
        List<S> results = new ArrayList<>();
        for (T item : collection) {
            results.add(mapper.map(item));
        }
        return results;
    }

    /**
     * Map many list.
     *
     * @param <T>        the type parameter
     * @param <S>        the type parameter
     * @param collection the collection
     * @param mapper     the mapper
     * @return the list
     */
    public static <T, S> List<S> mapMany(List<T> collection, Mapper<T, List<S>> mapper) {
        if (collection == null) {
            return new ArrayList<>();
        }
        List<S> results = new ArrayList<>();
        for (T item : collection) {
            List<S> m = mapper.map(item);
            if (m != null) {
                results.addAll(m);
            }
        }
        return results;
    }

    /**
     * Filter list.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the list
     */
    public static <T> List<T> filter(List<T> collection, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T item : collection) {
            if (predicate.eval(item)) {
                results.add(item);
            }
        }
        return results;
    }

    /**
     * Any boolean.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the boolean
     */
    public static <T> boolean any(Iterable<T> collection, Predicate<T> predicate) {
        for (T item : collection) {
            if (predicate.eval(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * All boolean.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the boolean
     */
    public static <T> boolean all(Iterable<T> collection, Predicate<T> predicate) {
        for (T item : collection) {
            if (!predicate.eval(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Count int.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param predicate  the predicate
     * @return the int
     */
    public static <T> int count(Iterable<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T item : collection) {
            if (predicate.eval(item)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Any boolean.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @return the boolean
     */
    public static <T> boolean any(List<T> collection) {
        return collection != null && collection.size() > 0;
    }

    /**
     * Distinct list.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @return the list
     */
    public static <T> List<T> distinct(final List<T> collection) {
        final List<T> results = new ArrayList<>();
        each(collection, new Action<T>() {
            @Override
            public void eval(final T item) {
                boolean found = any(results, new Predicate<T>() {
                    @Override
                    public boolean eval(T x) {
                        return x.equals(item);
                    }
                });
                if (!found) {
                    results.add(item);
                }
            }
        });
        return results;
    }

    /**
     * Group by list.
     *
     * @param <TKey>     the type parameter
     * @param <TElement> the type parameter
     * @param collection the collection
     * @param mapper     the mapper
     * @return the list
     */
    public static <TKey, TElement> List<Grouping<TKey, TElement>> groupBy(List<TElement> collection,
                                                                          final Mapper<TElement, TKey> mapper) {
        List<Grouping<TKey, TElement>> results = new ArrayList<>();

        for (TElement item : collection) {
            final TKey key = mapper.map(item);
            Grouping<TKey, TElement> grouping = first(results, new Predicate<Grouping<TKey, TElement>>() {
                @Override
                public boolean eval(Grouping<TKey, TElement> item) {
                    return item.getKey().equals(key);
                }
            });
            if (grouping == null) {
                results.add(new GroupingImpl<>(key, item));
            } else {
                grouping.add(item);
            }
        }
        return results;
    }

    /**
     * Top list.
     *
     * @param <T>        the type parameter
     * @param collection the collection
     * @param count      the count
     * @return the list
     */
    public static <T> List<T> top(List<T> collection, int count) {
        if (collection == null || collection.size() <= count) {
            return collection;
        }

        List<T> results = new ArrayList<>();
        for (T item : collection) {
            if (results.size() == count) {
                break;
            }
            results.add(item);
        }
        return results;
    }
    public static <T> List<T> toList(Iterable<T> iterable){
        ArrayList<T> returnValue = new ArrayList<>();
        for (T e : iterable) {
            returnValue.add(e);
        }
        return returnValue;
    }
}
