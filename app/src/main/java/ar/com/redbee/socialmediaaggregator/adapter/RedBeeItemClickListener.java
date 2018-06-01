package ar.com.redbee.socialmediaaggregator.adapter;

import android.view.View;

/**
 * Created by lvalido on 01/01/1900.
 */
public interface RedBeeItemClickListener<T> {
    /**
     * On click listener.
     *
     * @param v      the v
     * @param entity the entity
     */
    void onClickListener(View v, T entity);
}
