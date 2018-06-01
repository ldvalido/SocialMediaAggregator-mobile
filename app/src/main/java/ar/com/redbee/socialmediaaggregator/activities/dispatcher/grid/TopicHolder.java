package ar.com.redbee.socialmediaaggregator.activities.dispatcher.grid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ar.com.redbee.socialmediaaggregator.R;
import ar.com.redbee.socialmediaaggregator.adapter.RedBeeHolder;
import ar.com.redbee.socialmediaaggregator.adapter.RedBeeItemClickListener;
import ar.com.redbee.socialmediaaggregator.adapter.RedBeeItemLongClickListener;
import ar.com.redbee.socialmediaaggregator.adapter.RedBeeItemOptionListener;

public class TopicHolder extends RedBeeHolder {
    TextView txtTopicName;
    ImageView imgContentTypeUser;
    ImageView imgContentTypeSubject;
    /**
     * Instantiates a new Epec holder.
     *
     * @param itemView          the item view
     * @param listener
     * @param longClickListener
     * @param optionListener
     */
    public TopicHolder(View itemView, RedBeeItemClickListener listener, RedBeeItemLongClickListener longClickListener, RedBeeItemOptionListener optionListener) {
        super(itemView, listener, longClickListener, optionListener);
        txtTopicName = (TextView)itemView.findViewById(R.id.fragmentItem_txtTopicName);
        imgContentTypeUser = (ImageView) itemView.findViewById(R.id.fragment_imgContentTypeUser);
        imgContentTypeSubject = (ImageView) itemView.findViewById(R.id.fragment_imgContentTypeSubject);

    }
}
