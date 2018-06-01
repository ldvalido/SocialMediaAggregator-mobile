package ar.com.redbee.socialmediaaggregator.commons.web.type;


import ar.com.redbee.socialmediaaggregator.commons.utils.GenericUtils;

public enum HttpRequestMethodType {
    DELETE("delete"), GET("get"), POST("post"), POST_FILE("post_file"), PUT("put");
    private String methodName;

    private HttpRequestMethodType(String methodName) {
        this.methodName = methodName;
    }


    public static HttpRequestMethodType fromString(String methodName) {
        if (GenericUtils.isEmpty(methodName))
            throw new IllegalArgumentException("The methodName couldn't be null");

        return HttpRequestMethodType.valueOf(methodName);
    }

    public String toString() {
        return methodName;
    }
}
