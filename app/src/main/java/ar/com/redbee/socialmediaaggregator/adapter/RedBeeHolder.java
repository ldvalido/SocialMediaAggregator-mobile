package ar.com.redbee.socialmediaaggregator.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lvalido on 01/01/1900.
 */
public abstract class RedBeeHolder extends RecyclerView.ViewHolder{
    /**
     * Instantiates a new Epec holder.
     *
     * @param itemView the item view
     */
    public RedBeeHolder(
            final View itemView,
            final RedBeeItemClickListener listener,
            final RedBeeItemLongClickListener longClickListener,
            final RedBeeItemOptionListener optionListener) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickListener(v,itemView.getTag() );
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClickListener.onLongClickListener(v, itemView.getTag() );
                return true;
            }
        });

    }
}
