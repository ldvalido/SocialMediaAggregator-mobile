package ar.com.redbee.socialmediaaggregator.commons.web.model;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import ar.com.redbee.socialmediaaggregator.commons.web.type.ContentType;
import ar.com.redbee.socialmediaaggregator.commons.web.type.HttpRequestMethodType;

public class HttpSimpleRequest {
    private String url;
    private HttpRequestMethodType methodType;
    private HashMap<String, String> postParameters;
    private ContentType contentType;
    private List<File> files;
    private String fileParameterName;
    private Object requestEntity;

    public HttpSimpleRequest() {
        super();
        postParameters = new HashMap<>();
    }

    public HttpSimpleRequest(String url, HttpRequestMethodType methodType) {
        super();
        this.url = url;
        this.methodType = methodType;
    }

    public HttpSimpleRequest(String url, HttpRequestMethodType methodType, HashMap<String, String> postParameters) {
        super();
        this.url = url;
        this.methodType = methodType;
        this.postParameters = postParameters;
    }

    /**
     * Builds the request with all the paramaters
     *
     * @param url
     * @author Gabriel Villoldo
     */
    public HttpSimpleRequest(String url, HttpRequestMethodType methodType, Object requestEntity, ContentType contentType) {
        this.url = url;
        this.methodType = methodType;
        this.requestEntity = requestEntity;
        this.contentType = contentType;
    }

    /**
     * Builds the request for file upload
     *
     * @param url
     * @author Gabriel Villoldo
     */
    public HttpSimpleRequest(String url, String fileParameterName, File... files) {
        this(url, null, fileParameterName, files);
    }

    /**
     * Builds the request for file upload with a list of parameters
     *
     * @param url
     * @author Gabriel Villoldo
     */
    public HttpSimpleRequest(String url, HashMap<String, String> postParameters, String fileParameterName, File... files) {
        super();
        this.url = url;
        this.files = Arrays.asList(files);
        this.fileParameterName = fileParameterName;
        this.contentType = ContentType.MULTIPART_FORM_DATA;
        this.postParameters = postParameters;
        this.methodType = HttpRequestMethodType.POST_FILE;
    }

    public HttpSimpleRequest(String url, HashMap<String, String> postParameters, String fileParameterName, List<File> files) {
        super();
        this.url = url;
        this.files = files;
        this.fileParameterName = fileParameterName;
        this.contentType = ContentType.MULTIPART_FORM_DATA;
        this.postParameters = postParameters;
        this.methodType = HttpRequestMethodType.POST_FILE;
    }

    public HttpSimpleRequest(String url, HttpRequestMethodType methodType, HashMap<String, String> postParameters,
                             ContentType contentType) {
        this(url, methodType, postParameters);
        this.contentType = contentType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }


    public HttpRequestMethodType getMethodType() {
        return methodType;
    }


    public void setMethodType(HttpRequestMethodType methodType) {
        this.methodType = methodType;
    }


    public HashMap<String, String> getPostParameters() {
        return postParameters;
    }


    public void setPostParameters(HashMap<String, String> postParameters) {
        this.postParameters = postParameters;
    }

    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getFileParameterName() {
        return fileParameterName;
    }


    public void setFileParameterName(String fileParameterName) {
        this.fileParameterName = fileParameterName;
    }

    public List<File> getFiles() {
        return files;
    }


    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Object getRequestEntity() {
        return requestEntity;
    }
}