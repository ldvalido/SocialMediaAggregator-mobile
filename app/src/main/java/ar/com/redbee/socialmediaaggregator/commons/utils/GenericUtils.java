package ar.com.redbee.socialmediaaggregator.commons.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public final class GenericUtils {

    public static String buildStringFromInputStream(InputStream is) throws IOException {
        try {

            String result = IOUtils.toString(is);
            if (result.indexOf('{') < 0) {
                return null;
            }

            // Delete whitespaces on startup
            result = result.substring(result.indexOf('{'));
            return result;
        } finally {
            if (is != null)
                is.close();
        }
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static boolean isEmpty(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(cs.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
