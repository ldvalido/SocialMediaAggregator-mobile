package ar.com.redbee.socialmediaaggregator.commons.web.type;

public enum ContentType {
    JSON("application/json"), XML("application/xml"), MULTIPART_FORM_DATA("multipart/form-data"), OCTET_STREAM(
            "application/octet-stream"), URL_ENCODED("x-www-form-urlencoded");
    public static final String CONTENT_TYPE = "content-type";
    private String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
}
