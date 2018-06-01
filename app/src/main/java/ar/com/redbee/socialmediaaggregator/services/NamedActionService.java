package ar.com.redbee.socialmediaaggregator.services;

/**
 * Created by lvalido on 01/01/1900.
 */
public class NamedActionService {

    private Integer method;
    private String mockFile;
    private String url;


    /**
     * Instantiates a new Named action service.
     *
     * @param method   the method
     * @param mockFile the mock file
     * @param url      the url
     */
    public NamedActionService(Integer method, String mockFile, String url) {
        this.method = method;
        this.mockFile = mockFile;
        this.url = url;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public Integer getMethod() {
        return method;
    }

    /**
     * Gets mock file.
     *
     * @return the mock file
     */
    public String getMockFile() {
        return mockFile;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}
