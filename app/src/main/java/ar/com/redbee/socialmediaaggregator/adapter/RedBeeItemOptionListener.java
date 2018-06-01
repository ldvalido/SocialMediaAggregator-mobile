package ar.com.redbee.socialmediaaggregator.adapter;

import android.view.View;

/**
 * Created by lvalido on 07/02/2018.
 */

public interface RedBeeItemOptionListener<T> {
    /**
     * On click listener.
     *
     * @param v      the v
     * @param entity the entity
     */
    void onOptionClickListener(View v, T entity, String actionName);
}
