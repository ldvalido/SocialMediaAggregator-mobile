package ar.com.redbee.socialmediaaggregator.services;

import java.util.Collection;

/**
 * Created by lvalido on 01/01/1900.
 */
public class NamedService {

    private Class clazz;
    private Collection<NamedActionService> namedActionServices;

    /**
     * Instantiates a new Named service.
     *
     * @param clazz               the clazz
     * @param namedActionServices the named action services
     */
    public NamedService(Class clazz, Collection<NamedActionService> namedActionServices) {
        this.clazz = clazz;
        this.namedActionServices = namedActionServices;
    }

    /**
     * Gets clazz.
     *
     * @return the clazz
     */
    public Class getClazz() {
        return clazz;
    }

    /**
     * Gets named action services.
     *
     * @return the named action services
     */
    public Collection<NamedActionService> getNamedActionServices() {
        return namedActionServices;
    }
}