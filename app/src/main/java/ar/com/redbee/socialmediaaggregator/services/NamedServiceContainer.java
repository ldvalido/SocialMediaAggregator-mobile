package ar.com.redbee.socialmediaaggregator.services;

/**
 * Created by lvalido on 01/01/1900.
 */

import java.util.ArrayList;
import java.util.List;

import ar.com.redbee.socialmediaaggregator.services.database.DataBaseInfoService;

/**
 * The type Named service container.
 */
public class NamedServiceContainer {

    /**
     * Gets data base info.
     *
     * @return the data base info
     */
    public static NamedService getDataBaseInfo() {
        List<NamedActionService> namedActionServices = new ArrayList<>();

        return new NamedService(DataBaseInfoService.class, namedActionServices);
    }

}
