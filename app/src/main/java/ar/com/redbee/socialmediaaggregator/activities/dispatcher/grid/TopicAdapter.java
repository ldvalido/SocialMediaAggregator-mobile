package ar.com.redbee.socialmediaaggregator.activities.dispatcher.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ar.com.redbee.socialmediaaggregator.R;
import ar.com.redbee.socialmediaaggregator.adapter.RedBeeAdapter;
import ar.com.redbee.socialmediaaggregator.domain.dto.TopicDto;

public class TopicAdapter extends RedBeeAdapter<TopicDto,TopicHolder>{

    public TopicAdapter(List<TopicDto> items, Context context) {
        super(items, context);
    }

    @Override
    public TopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_topic_item,
                parent,
                false);
        return new TopicHolder(v,this,this,this);
    }

    @Override
    public void onBindViewHolder(TopicHolder holder, int position) {
        TopicDto item = this.items.get(position);
        holder.txtTopicName.setText(item.getPatternFind());
        if (item.isUserTopic()){
            holder.imgContentTypeUser.setVisibility(View.VISIBLE);
            holder.imgContentTypeSubject.setVisibility(View.GONE);

        }else{
            holder.imgContentTypeUser.setVisibility(View.GONE);
            holder.imgContentTypeSubject.setVisibility(View.VISIBLE);
        }
    }
}
