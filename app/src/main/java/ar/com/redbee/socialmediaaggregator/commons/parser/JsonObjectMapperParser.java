package ar.com.redbee.socialmediaaggregator.commons.parser;

import android.util.Log;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import ar.com.redbee.socialmediaaggregator.commons.utils.GenericUtils;

public class JsonObjectMapperParser implements Parser {

    // -------------------
    // Static
    // -------------------
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String TAG = JsonObjectMapperParser.class.getSimpleName();

    static {
        OBJECT_MAPPER.setAnnotationIntrospector(new JsonAnnotationCaseInsensitive());
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);
        OBJECT_MAPPER.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
    }

    // -------------------
    // Instance
    // -------------------
    private Class responseClazz;

    public JsonObjectMapperParser() {
    }

    public JsonObjectMapperParser(Class clazz) {
        setResponseClazz(clazz);
    }

    private static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    public void setResponseClazz(Class responseClazz) {
        this.responseClazz = responseClazz;
    }

    @Override
    public <T> Collection<T> parseCollection(InputStream inputStream) {

        //convert json string to object
        Collection<T> response = null;
        try {
            ObjectMapper mapper = getObjectMapper();
            response = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(Collection.class, responseClazz));
        } catch (IOException e) {
            Log.w(TAG, e);
        }

        return response;
    }

    @Override
    public <T> Collection<T> parseCollection(String json) {
        if (json == null)
            return null;

        //convert json string to object
        Collection<T> response = null;
        try {
            if (json.indexOf("[") != 0)
                json = "[" + json + "]";

            ObjectMapper mapper = getObjectMapper();
            response = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(Collection.class, responseClazz));
        } catch (IOException e) {
            Log.w(TAG, e);
        }

        return response;
    }

    @Override
    public <T> T parse(InputStream inputStream) {

        //convert json string to object
        T response = null;
        try {
            response = (T) getObjectMapper().readValue(inputStream, responseClazz);
        } catch (IOException e) {
            Log.w(TAG, e);
        }

        return response;
    }

    @Override
    public <T> T parse(String json) {
        if (GenericUtils.isEmpty(json))
            return null;

        //convert json string to object
        T response = null;
        try {
            response = (T) getObjectMapper().readValue(json, responseClazz);
        } catch (IOException e) {
            Log.w(TAG, e);
        }

        return response;
    }

    @Override
    public String writeAsString(Object object) {
        if (object == null)
            return null;

        //convert object to string
        String response = null;
        try {
            response = new ObjectMapper().writeValueAsString(object);
        } catch (IOException e) {
            Log.w(TAG, e);
        }

        return response;
    }
}
