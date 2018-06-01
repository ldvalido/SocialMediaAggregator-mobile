package ar.com.redbee.socialmediaaggregator.adapter;

import android.view.View;

/**
 * Created by lvalido on 01/01/1900.
 */
public interface RedBeeItemLongClickListener<T> {

    /**
     * On long click listener.
     *
     * @param v      the v
     * @param entity the entity
     */
    void onLongClickListener(View v, T entity);
}
