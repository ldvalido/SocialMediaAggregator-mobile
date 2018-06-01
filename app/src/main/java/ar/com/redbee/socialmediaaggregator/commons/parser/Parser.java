package ar.com.redbee.socialmediaaggregator.commons.parser;

import java.io.InputStream;
import java.util.Collection;

public interface Parser {

    /**
     * Parse the inputStream
     *
     * @param inputStream The inputStream to parseCollection
     * @return collection<T> parsed from input
     */
    <T> Collection<T> parseCollection(InputStream inputStream);

    /**
     * @param inputStream
     * @param <T>
     * @return return an object of type T instead of a collection
     */
    <T> T parse(InputStream inputStream);

    /**
     * @param input
     * @param <T>
     * @return collection<T> parsed from input
     */
    <T> Collection<T> parseCollection(String input);

    /**
     * @param input
     * @param <T>
     * @return return an object of type T instead of a collection
     */
    <T> T parse(String input);

    /**
     * @param object
     * @return object as json string
     */
    String writeAsString(Object object);
}
