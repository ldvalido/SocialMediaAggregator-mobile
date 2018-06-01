package ar.com.redbee.socialmediaaggregator.commons.parser;

import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class JsonAnnotationCaseInsensitive extends JacksonAnnotationIntrospector {
    private PropertyName toLowerCase(PropertyName propertyName) {
        if (propertyName == null)
            return null;

        return new PropertyName(propertyName.getSimpleName() != null ? propertyName.getSimpleName().toLowerCase() : null,
                propertyName.getNamespace() != null ? propertyName.getNamespace().toLowerCase() : null);
    }

    @Override
    public PropertyName findNameForDeserialization(Annotated a) {
        return toLowerCase(super.findNameForDeserialization(a));
    }

    @Override
    public PropertyName findNameForSerialization(Annotated a) {
        return toLowerCase(super.findNameForSerialization(a));
    }
}
