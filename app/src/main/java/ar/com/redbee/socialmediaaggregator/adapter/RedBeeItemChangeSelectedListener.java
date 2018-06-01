package ar.com.redbee.socialmediaaggregator.adapter;

import java.util.List;

/**
 * Created by lvalido on 01/01/1900.
 */
public interface RedBeeItemChangeSelectedListener<T> {

    /**
     * On selection change.
     *
     * @param entity the entity
     */
    void onSelectionChange(List<T> entity);
}
